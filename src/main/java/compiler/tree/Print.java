package compiler.tree;

import java.util.Stack;


import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

public class Print extends Node {

	public Print(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}
	
	public void execute (Stack<Object> stack) {
		super.execute(stack);
		System.out.println(stack.pop());
	}

    @Override
    public void generateBytecode(MethodVisitor mv) {
       String type = null;
       mv.visitFieldInsn(GETSTATIC,"java/lang/System","out", "Ljava/io/PrintStream;");
       Node child = getChild(0);
       child.generateBytecode(mv);
       mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", child.getTypeDef().getJavaDescriptor()+"V");
       mv.visitInsn(RETURN);

    }
}
