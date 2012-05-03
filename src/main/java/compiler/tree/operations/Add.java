package compiler.tree.operations;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

import java.util.Stack;

public class Add extends Arithmetic {

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
}
