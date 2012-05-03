package compiler.tree.operations;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

public class Div extends Arithmetic {

	public Div(Token token) {
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
            return object2.floatValue() / object1.floatValue();
        }else{
            return object2.intValue() / object1.intValue();
        }

    }
}
