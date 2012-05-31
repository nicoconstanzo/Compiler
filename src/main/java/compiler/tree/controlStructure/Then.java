package compiler.tree.controlStructure;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 31/05/12
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
public class Then extends Node {
    public Then(Token token) {
        super(token);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        super.analyze(symbolTable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void execute(Stack<Object> stack) {
        super.execute(stack);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        super.generateBytecode(mv);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
