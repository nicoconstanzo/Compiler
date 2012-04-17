package compiler.tree.operations;

import java.util.Stack;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

public class Sub extends Arithmetics {

	public Sub(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}


    @Override
    public Number operation(Number object1, Number object2) {
        if(getTypeDef()==Type.FLOAT){
            return object1.floatValue() - object2.floatValue();
        }else{
            return object1.intValue() - object2.intValue();
        }

    }
}
