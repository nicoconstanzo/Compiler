package compiler.tree.controlStructure;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.Token;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

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

    //ASk HOW TO GET THE LABEL WE HAVE SET TO THE EQUALS, EQUALS, GREATER or LESSER
    @Override
    public void generateBytecode(MethodVisitor mv) {
//        super.generateBytecode(mv);
//
//        Label jumpInstruction = getChild(0).getLabel();
//        mv.visitLabel(jumpInstruction);
    }


}
