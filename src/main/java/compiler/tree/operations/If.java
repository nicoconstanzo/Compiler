package compiler.tree.operations;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 31/05/12
 * Time: 10:34
 * To change this template use File | Settings | File Templates.
 */
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
        super.generateBytecode(mv);
    }


}
