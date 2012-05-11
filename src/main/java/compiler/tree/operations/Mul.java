package compiler.tree.operations;

import com.sun.xml.internal.bind.v2.TODO;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

public class Mul extends Arithmetic {

	public Mul(Token token) {
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
            return object1.floatValue() * object2.floatValue();
        }else{
            return object1.intValue() * object2.intValue();
        }

    }

    @Override
    public void generateBytecode(MethodVisitor mv) {
        Type type1 = getChild(0).getTypeDef();
        Type type2 = getChild(1).getTypeDef();
        if (getTypeDef().isInteger()) {
            super.generateBytecode(mv);
            mv.visitInsn(IMUL);
        } else if (getTypeDef().isFloat()) {
            getChild(0).generateBytecode(mv);
            if (type1.isInteger()){
                mv.visitInsn(I2F);
            }

            getChild(1).generateBytecode(mv);
            if (type2.isInteger()){
                mv.visitInsn(I2F);
            }
            mv.visitInsn(FMUL);

        } else {
//            TODO exception para strings!
        }
    }
}
