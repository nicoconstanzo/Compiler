package compiler.tree.values;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;

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
    public String getText() {
        String text = super.getText();
        return text.substring(1, text.length() - 1);

    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        setTypeDef(Type.STRING);
    }


    @Override
    public void execute (Stack<Object> stack) {
        stack.push(getText());
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        mv.visitLdcInsn(getText());
    }
}
