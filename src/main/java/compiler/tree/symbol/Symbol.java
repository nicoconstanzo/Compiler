package compiler.tree.symbol;

import compiler.tree.Node;
import compiler.tree.types.Type;

public class Symbol {


    Object value;
    Type type;
    int index ;


    public Symbol(Object value, Type type, int index){
        this.value= value;
        this.type = type;
        this.index = index;


    }



    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }
    
    public int getIndex(){
        return index;
        
    }

	
	

}
