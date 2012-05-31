package compiler.tree.booleanLogic;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import compiler.tree.values.BooleanValue;
import org.antlr.runtime.Token;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

import java.util.Stack;

public class GreaterThan extends Node {

    public GreaterThan (Token token) {
        super(token);
    }

    @Override
    public void execute(Stack<Object> stack) {
        super.execute(stack);
        Number i1 = (Number) stack.pop();
        Number i2 = (Number) stack.pop();

        if (i2.floatValue() > i1.floatValue()) {
            stack.push(BooleanValue.TRUE_VALUE);
        } else {
            stack.push(BooleanValue.FALSE_VALUE);
        }
    }



    @Override
    public void analyze(SymbolTable symbolTable) {
        super.analyze(symbolTable);
        setTypeDef(Type.BOOLEAN);
    }



    @Override
    public void generateBytecode(MethodVisitor mv) {
        Label booleanLabel = new Label();
        Label endLabel = new Label();
        Node child0 = getChild(0);
        Node child1 = getChild(1);
        if(child0.getTypeDef().isInteger() && child1.getTypeDef().isInteger()){
            mv.visitJumpInsn(IF_ICMPGE,booleanLabel);
            child0.generateBytecode(mv);
            mv.visitLabel(booleanLabel);
            mv.visitJumpInsn(GOTO, endLabel);
            child1.generateBytecode(mv);
            mv.visitLabel(endLabel);
        }else if(child0.getTypeDef().isFloat() && child1.getTypeDef().isFloat()){

        }

    }

}
