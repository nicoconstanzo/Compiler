package compiler.tree.operations;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 29/03/12
 * Time: 19:08
**/

public abstract class Arithmetic extends Node {
    
    public Arithmetic(Token token) {
        super(token);
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        super.analyze(symbolTable);

        Type t1 = getChild(0).getTypeDef();
        Type t2 = getChild(1).getTypeDef();
        setTypeDef(Type.promotion(t1, t2));

    }

    @Override
    public void execute(Stack<Object> stack){

        super.execute(stack); //evalua los hijos para ver si son integers o no.
        if (getTypeDef().equals(Type.INTEGER)) {
            Number i1 = (Number) stack.pop();
            Number i2 = (Number) stack.pop();
            stack.push(operation(i1,i2));

        } else if(getTypeDef().equals(Type.FLOAT)) {
            Number f1 = (Number) stack.pop();
            Number f2 = (Number) stack.pop();
            stack.push(operation(f1,f2));

        } else {
            String f1 = (String) stack.pop();
            String f2 = (String) stack.pop();
            stack.push(operation(f2,f1));
        }

    }
    public abstract String operation(String object1, String object2);

    public abstract Number operation(Number object1, Number object2);
}
