package compiler.tree.booleanLogic;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import compiler.tree.values.BooleanValue;
import org.antlr.runtime.Token;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;


import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 5/29/12
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */

public class LessThan extends Node {

    public LessThan(Token token) {
        super(token);
    }

    @Override
    public void execute(Stack<Object> stack) {
        super.execute(stack);
        Number i1 = (Number) stack.pop();
        Number i2 = (Number) stack.pop();

        if (i2.floatValue() < i1.floatValue()) {
            stack.push(BooleanValue.TRUE_VALUE);
        } else {
            stack.push(BooleanValue.FALSE_VALUE);
        }
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        super.analyze(symbolTable);
        setTypeDef(Type.BOOLEAN);
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        super.generateBytecode(mv); 
        Label label = new Label();
        mv.visitJumpInsn(IF_ICMPLE,label);
    }



}
