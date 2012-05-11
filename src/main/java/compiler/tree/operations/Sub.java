package compiler.tree.operations;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class Sub extends Arithmetic {

    private static final String JAVA_LANG_STRING_BUILDER = "java/lang/StringBuilder";

    public Sub(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

    @Override
    public String operation(String object1, String object2) {
        return null;
    }


    @Override
    public Number operation(Number object1, Number object2) {
        if(getTypeDef()==Type.FLOAT){
            return object2.floatValue() - object1.floatValue();
        }else{
            return object2.intValue() - object1.intValue();
        }

    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        Type type1 = getChild(0).getTypeDef();
        Type type2 = getChild(1).getTypeDef();
        if (getTypeDef().isInteger()) {
            super.generateBytecode(mv);
            mv.visitInsn(ISUB);
        } else if (getTypeDef().isFloat()) {
            getChild(0).generateBytecode(mv);
            if (type1.isInteger()){
                mv.visitInsn(I2F);
            }

            getChild(1).generateBytecode(mv);
            if (type2.isInteger()){
                mv.visitInsn(I2F);
            }
            mv.visitInsn(FSUB);
        } else if (getTypeDef().isString()) {
            //TODO hace excepcion de que no se puede realizar!!
        }
    }
}
