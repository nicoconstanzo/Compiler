package compiler.tree.symbol;

import compiler.tree.types.Type;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 * Date: 07/06/12
 * Time: 19:55
 * To change this template use File | Settings | File Templates.
 */
public class FunctionSymbol  extends Symbol{
    public FunctionSymbol(Object value, Type type, int index) {
        super(value, type, index);
    }
}
