package compiler.tree.controlStructure;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.Token;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

import java.util.Stack;


public class If extends Node {
    public If(Token token) {
        super(token);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        super.analyze(symbolTable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void execute(Stack<Object> stack) {
        super.execute(stack);
    }


    @Override
    public void generateBytecode(MethodVisitor mv) {
        Label elseLabel = new Label();
        Label endLabel = new Label();
        if (getChild(2).isNil()) {
           elseLabel=endLabel;
        }
        getChild(0).generateBytecode(mv);
        mv.visitJumpInsn(IFEQ, elseLabel);
        getChild(1).generateBytecode(mv);
        mv.visitJumpInsn(GOTO, endLabel);
        mv.visitLabel(elseLabel);
        getChild(2).generateBytecode(mv);

        mv.visitLabel(endLabel);

    }


}
