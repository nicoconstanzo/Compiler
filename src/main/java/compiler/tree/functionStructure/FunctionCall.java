package compiler.tree.functionStructure;

import compiler.tree.Node;
import compiler.tree.symbol.FunctionSymbol;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 07/06/12
 * Time: 20:02
 * To change this template use File | Settings | File Templates.
 */

public class FunctionCall extends Node {
    public FunctionCall(Token token) {
        super(token);
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        String name = getChild(0).getText();
        
        
        FunctionSymbol symbol = symbolTable.lookupFunction(name);
        // Analizar que la cantidad de parametros es correcta y que los tipos tambien coinciden.
        super.analyze(symbolTable);
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        super.generateBytecode(mv);
        // Hacerlo como en los otros (string builder... )
    }
}
