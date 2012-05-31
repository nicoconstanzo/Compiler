package compiler.tree.booleanLogic;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.values.BooleanValue;
import org.antlr.runtime.Token;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;


import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 27/05/12
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
public class Equals extends Node {

    public Equals(Token token) {
        super(token);
    }

    @Override
    public void execute(Stack<Object> stack) {
        super.execute(stack);
        Number i1 = (Number) stack.pop();
        Number i2 = (Number) stack.pop();

        if (i2.floatValue() == i1.floatValue()) {
            stack.push(BooleanValue.TRUE_VALUE);
        } else {
            stack.push(BooleanValue.FALSE_VALUE);
        }
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        super.analyze(symbolTable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        Label booleanLabel = new Label();
        mv.visitJumpInsn(IF_ICMPNE,booleanLabel);
        getChild(0).generateBytecode(mv);
        mv.visitLabel(booleanLabel);
        Label endLabel = new Label();
        mv.visitJumpInsn(GOTO, endLabel);
        getChild(1).generateBytecode(mv);
        mv.visitLabel(endLabel);
    }


}
