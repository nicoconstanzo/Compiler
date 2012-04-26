package compiler.tree.operations;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

public class Add extends Arithmetic {

    public Add(Token token) {
        super(token);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Number operation(Number object1, Number object2) {
           if(getTypeDef()==Type.FLOAT){
                return object1.floatValue() + object2.floatValue();
           }
//           else if(getTypeDef()==Type.STRING){
//               return object1.toString().concat(object2.toString());
//           }
           else{
               return object1.intValue() + object2.intValue();
           }

    }
}
