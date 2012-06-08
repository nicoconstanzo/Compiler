package compiler.tree.symbol;

import compiler.tree.types.Type;

import java.util.HashMap;

public class SymbolTable {

    HashMap <String,Symbol> st = new HashMap<String, Symbol>();
    int index = 1;
    private SymbolTable parent;
    HashMap <String, FunctionSymbol> functionSymbol = new HashMap<String, FunctionSymbol>();

    public SymbolTable (SymbolTable st) {
        this.parent = st;           
    }
    
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
    
    public FunctionSymbol lookupFunction (String name) {
        FunctionSymbol result = functionSymbol.get(name);
        if (result == null && parent != null) {
            result = parent.lookupFunction(name);
        }
        return result;
    }
}
