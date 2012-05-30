package compiler.tree.operations;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

import java.util.Stack;

public class Add extends Arithmetic {

    public static final String JAVA_LANG_STRING_BUILDER = "java/lang/StringBuilder";

    public Add(Token token) {
        super(token);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String operation(String object1, String object2) {
        return object1.toString() + object2.toString();
    }

    @Override
    public Number operation(Number object1, Number object2) {
           if(getTypeDef()==Type.FLOAT){
                return object1.floatValue() + object2.floatValue();
           }
           else{
               return object1.intValue() + object2.intValue();
           }

    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        Type type1 = getChild(0).getTypeDef();
        Type type2 = getChild(1).getTypeDef();
        if (getTypeDef().isInteger()) {
            super.generateBytecode(mv);
            mv.visitInsn(IADD);
        } else if (getTypeDef().isFloat()) {
            getChild(0).generateBytecode(mv);
            if (type1.isInteger()){
                mv.visitInsn(I2F);
            }

            getChild(1).generateBytecode(mv);
            if (type2.isInteger()){
                mv.visitInsn(I2F);
            }
            mv.visitInsn(FADD);
        } else if (getTypeDef().isString()) {
            mv.visitTypeInsn(NEW, JAVA_LANG_STRING_BUILDER);
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, JAVA_LANG_STRING_BUILDER, "<init>", "()V");
            getChild(0).generateBytecode(mv);
            mv.visitMethodInsn(INVOKEVIRTUAL, JAVA_LANG_STRING_BUILDER, "append", type1.getJavaDescriptor()+ "Ljava/lang/StringBuilder;");
            getChild(1).generateBytecode(mv);
            mv.visitMethodInsn(INVOKEVIRTUAL, JAVA_LANG_STRING_BUILDER, "append", type2.getJavaDescriptor() + "Ljava/lang/StringBuilder;");
            mv.visitMethodInsn(INVOKEVIRTUAL, JAVA_LANG_STRING_BUILDER, "toString", "()Ljava/lang/String;");
        }

    }
}
