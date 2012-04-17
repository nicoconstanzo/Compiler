package compiler.tree.operations;

import java.util.Stack;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

public class Div extends Arithmetics {

	public Div(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

    @Override
    public Number operation(Number object1, Number object2) {
        if(getTypeDef()==Type.FLOAT){
            return object2.floatValue() / object1.floatValue();
        }else{
            return object2.intValue() / object1.intValue();
        }

    }
}
