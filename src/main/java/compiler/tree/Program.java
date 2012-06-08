package compiler.tree;

import compiler.tree.operations.Function;
import compiler.tree.symbol.SymbolTable;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Program extends Node {
    public Program(Token token) {
        super(token);
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        super.generateBytecode(mv);
        mv.visitInsn(Opcodes.RETURN);
    }

    @Override
    public void addChild(Tree tree) {
        if (tree instanceof Function) {
            super.addChild(tree);
        }
        else {
            // Crear funcion anonima y meter el codigo suelto aca.
        }

    }

    @Override
    public void analyze(SymbolTable symbolTable) {
        for(int i=0; i<getChildCount(); i++){
            getChild(i).analyze(symbolTable);

        }

    }
}
