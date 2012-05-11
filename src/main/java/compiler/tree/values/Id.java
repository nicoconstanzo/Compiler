package compiler.tree.values;

import compiler.tree.Node;
import compiler.tree.symbol.Symbol;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;


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

    @Override
    public void generateBytecode(MethodVisitor mv) {
        if (getTypeDef().isInteger()) {
            mv.visitVarInsn(ILOAD, symbol.getIndex());
        }
        else if (getTypeDef().isFloat()) {
            mv.visitVarInsn(FLOAD, symbol.getIndex());
        }
        else {
            mv.visitVarInsn(ALOAD, symbol.getIndex());
        }
    }
}
