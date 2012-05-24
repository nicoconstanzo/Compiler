package compiler.tree.values;

import com.sun.xml.internal.bind.v2.TODO;
import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 5/24/12
 * Time: 6:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class BooleanValue extends Node {

    public BooleanValue(Token token) {
        super(token);
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        setTypeDef(Type.BOOLEAN);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void execute(Stack<Object> stack) {
//        TODO
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        super.generateBytecode(mv);
        if(getText().equals("true")){
            mv.visitInsn(Opcodes.ICONST_1);
        } else if (getText().equals("false")){
            mv.visitInsn(Opcodes.ICONST_0);
        } else {
//            TODO Exception for none boolean input
        }

    }
}
