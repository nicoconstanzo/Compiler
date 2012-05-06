package compiler.tree.literals;

import compiler.tree.Node;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 26/04/12
 * Time: 16:09
 * To change this template use File | Settings | File Templates.
 */
public class LiteralString extends Node {
    public LiteralString(Token token) {
        super(token);
        setTypeDef(Type.STRING);
    }
}
