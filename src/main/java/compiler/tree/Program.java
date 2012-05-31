package compiler.tree;

import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Program extends Node {
    public Program(Token token) {
        super(token);
    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        super.generateBytecode(mv);    //To change body of overridden methods use File | Settings | File Templates.
        mv.visitInsn(Opcodes.RETURN);
    }
}
