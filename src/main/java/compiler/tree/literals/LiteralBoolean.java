package compiler.tree.literals;


import compiler.tree.Node;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;

public class LiteralBoolean extends Node {
    public LiteralBoolean(Token token) {
        super(token);
        setTypeDef(Type.BOOLEAN);
    }
}
