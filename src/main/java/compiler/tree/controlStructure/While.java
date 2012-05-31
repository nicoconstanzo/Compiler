package compiler.tree.controlStructure;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.Token;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

import java.util.Stack;


public class While extends Node {
    public While(Token token) {
        super(token);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void execute(Stack<Object> stack) {
        super.execute(stack);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        super.analyze(symbolTable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
//        Label loopInstruction = new Label();
//        super.generateBytecode(mv);
//        Label jumpInstruction = getChild(0).getLabel();
//        mv.visitJumpInsn(GOTO, loopInstruction);
//        mv.visitLabel(jumpInstruction);
    }
}
