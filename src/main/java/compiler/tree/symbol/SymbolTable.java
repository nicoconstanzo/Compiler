package compiler.tree.symbol;

import compiler.tree.types.Type;

import java.util.HashMap;

public class SymbolTable {

    HashMap <String,Symbol> st = new HashMap<String, Symbol>();
    int index = 1;
    
    public void declare(String name, Type type) {
        Symbol symbol = new Symbol(null, type, index++ );
        st.put(name, symbol);
    }
    
    public boolean lookup (String name) {
        return (st.containsKey(name));
    }
    
    public Symbol getSymbol(String name){
        return st.get(name);
    }
}
