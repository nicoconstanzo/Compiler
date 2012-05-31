package compiler.tree.booleanLogic;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import java.util.Stack;


public class And extends Node {

    public And(Token token) {
        super(token);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        setTypeDef(Type.BOOLEAN);
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
