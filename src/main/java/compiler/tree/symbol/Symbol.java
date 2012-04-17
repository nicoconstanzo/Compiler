package compiler.tree.symbol;

import compiler.tree.Node;
import compiler.tree.types.Type;

public class Symbol {


    Object value;
    Type type;


    public Symbol(Object value, Type type){
        this.value= value;
        this.type = type;


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

	
	

}
