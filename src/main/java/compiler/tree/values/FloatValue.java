package compiler.tree.values;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 22/03/12
 * Time: 19:44
 * To change this template use File | Settings | File Templates.
 */
public class FloatValue extends Node {
    public FloatValue(Token token) {
        super(token);
    }

    @Override
    public void execute (Stack<Object> stack) {
        stack.push(Float.parseFloat(getText()));
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        setTypeDef(Type.FLOAT);
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        super.generateBytecode(mv);
        mv.visitLdcInsn(Float.parseFloat(getText()));
   
    }
}
