package compiler.tree;

import compiler.tree.symbol.Symbol;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.values.Id;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

import java.util.Stack;

public class Assign extends Node{

    private Symbol symbol = null;

    public Assign(Token token) {
        super(token);
    }


    @Override
    public void analyze(SymbolTable symbolTable) {
        super.analyze(symbolTable);  
        Id idNode = (Id)getChild(0);
        if(symbolTable.lookup(idNode.getText())){
            symbol = symbolTable.getSymbol(idNode.getText());
            setTypeDef(symbol.getType());
        }


    }

    @Override
    public void execute(Stack<Object> stack) {
        getChild(1).execute(stack);
        symbol.setValue(stack.pop());
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        getChild(1).generateBytecode(mv);

        if(getTypeDef().isInteger() || getTypeDef().isBoolean()){
            mv.visitVarInsn(ISTORE,symbol.getIndex());
        }
        else if (getTypeDef().isFloat()) {
            mv.visitVarInsn(FSTORE, symbol.getIndex());
        }
        else {
            mv.visitVarInsn(ASTORE,symbol.getIndex());
        }
    }


}
