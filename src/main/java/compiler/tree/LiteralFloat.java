package compiler.tree;

import compiler.tree.types.Type;
import org.antlr.runtime.Token;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 29/03/12
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class LiteralFloat extends Node {


    public LiteralFloat(Token token) {
        super(token);
        setTypeDef(Type.FLOAT);
    }
}
