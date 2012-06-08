package compiler.tree.operations;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.Stack;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;


public class Function extends Node {
    public Function(Token token) {
        super(token);
    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        SymbolTable localTable = new SymbolTable(symbolTable);
        for(int i=1; i<getChildCount()-2; i++){
            getChild(i).analyze(localTable);

        }
        getChild(getChildCount()-1).analyze(localTable);


    }

    @Override
    public void execute(Stack<Object> stack) {
        super.execute(stack);
    }

    @Override
    public void generateBytecode(ClassWriter cw) {
        
        String functionName = getChild(0).getText();
        String parameter = null;
        for(int i=1; i<getChildCount()-2; i++){
            String name = getChild(i).getChild(0).getText();
            String type = getChild(i).getChild(1).getTypeDef().getJavaDescriptor();
            parameter = type.concat(type);
        }
        
        String returnType = getChild(getChildCount()-1).getText();
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, functionName , parameter+returnType, null, null);

        getChild(getChildCount()).generateBytecode(mv);
        
        mv.visitMaxs(0,0);

    }
}
