package compiler.tree;

import compiler.tree.symbol.Symbol;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 22/03/12
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
public class Declaration extends Node {

 

    public Declaration(Token token) {
        super(token);
    }

    public void execute(Stack<Object> stack){
        getChild(1).execute(stack);

    }

    public void analyze(SymbolTable symbolTable){
        Type type = getChild(1).getTypeDef();
        String name = getChild(0).getText();
        symbolTable.declare(name,type);
        getChild(0).analyze(symbolTable); //Visita el nodo y le dice que tipo es.

    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
//        Por ahora esto sirve.
    }
}
