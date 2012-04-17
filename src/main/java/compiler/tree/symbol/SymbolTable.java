package compiler.tree.symbol;

import java.util.HashMap;

public class SymbolTable {

    HashMap <String,Symbol> st = new HashMap<String, Symbol>();
    
    public void declare (String name, Symbol symbol) {
          st.put(name, symbol);
    }
    
    public boolean lookup (String name) {
        return (st.containsKey(name));
    }
    
    public Symbol getSymbol(String name){
        return st.get(name);
    }
}
