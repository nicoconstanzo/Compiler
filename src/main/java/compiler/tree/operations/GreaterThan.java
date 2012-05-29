package compiler.tree.operations;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import compiler.tree.values.BooleanValue;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 5/29/12
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class GreaterThan extends Node {

    public GreaterThan (Token token) {
        super(token);
    }

    public void execute(Stack<Object> stack) {
        super.execute(stack);
        Number i1 = (Number) stack.pop();
        Number i2 = (Number) stack.pop();

        if (i2.floatValue() > i1.floatValue()) {
            stack.push(BooleanValue.TRUE_VALUE);
        } else {
            stack.push(BooleanValue.FALSE_VALUE);
        }
    }

    public void analyze (SymbolTable st) {
        super.analyze(st);
        setTypeDef(Type.BOOLEAN);
    }

    public void generateBytecode (MethodVisitor mv) {
//  TODO generateBytecode for greaterThan
    }
}
