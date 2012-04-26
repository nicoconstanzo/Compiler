package compiler.tree.values;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 */

public class StringValue extends Node {


    public StringValue(Token token) {
        super(token);
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        setTypeDef(Type.STRING);
    }


    @Override
    public void execute (Stack<Object> stack) {
        stack.push(getText());
    }

}
