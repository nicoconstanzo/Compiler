package compiler.tree.values;

import compiler.tree.Node;
import compiler.tree.symbol.Symbol;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.Token;

import java.util.Stack;

public class Id extends Node {

    private Symbol symbol;

    public Id(Token token) {
        super(token);
    }
    
    public void execute(Stack<Object> stack){
        stack.push(symbol.getValue());
    }

    public void analyze(SymbolTable symbolTable){
        symbol = symbolTable.getSymbol(getText());
        setTypeDef(symbol.getType());

    }


}
