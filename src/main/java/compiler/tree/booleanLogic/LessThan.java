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

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 5/29/12
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */

public class LessThan extends Node {

    public LessThan(Token token) {
        super(token);
    }

    @Override
    public void execute(Stack<Object> stack) {
        super.execute(stack);
        Number i1 = (Number) stack.pop();
        Number i2 = (Number) stack.pop();

        if (i2.floatValue() < i1.floatValue()) {
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
            child1.generateBytecode(mv);
            mv.visitInsn(ICONST_1);
            mv.visitJumpInsn(GOTO, endLabel);
            mv.visitLabel(booleanLabel);
            mv.visitInsn(ICONST_0);
            mv.visitLabel(endLabel);
        }else if(child0.getTypeDef().isFloat() && child1.getTypeDef().isFloat()){
            generateByteCodeForFloat(mv,child0,child1,booleanLabel,endLabel);

        }else{
            child0.generateBytecode(mv);
            if (child0.getTypeDef().isInteger())  {
                mv.visitInsn(I2F);
            }
            child1.generateBytecode(mv);
            if(child1.getTypeDef().isInteger()){
                mv.visitInsn(I2F);
            }
            generateByteCodeForFloat(mv,child0,child1,booleanLabel,endLabel);
        }

    }

    private static void generateByteCodeForFloat(MethodVisitor mv, Node child0, Node child1, Label booleanLabel, Label endLabel){
        mv.visitInsn(FCMPG);
        mv.visitJumpInsn(IFGE,booleanLabel);
        child0.generateBytecode(mv);
        mv.visitInsn(ICONST_1);
        mv.visitJumpInsn(GOTO, endLabel);
        mv.visitLabel(booleanLabel);
        child1.generateBytecode(mv);
        mv.visitInsn(ICONST_0);
        mv.visitLabel(endLabel);
    }



}
