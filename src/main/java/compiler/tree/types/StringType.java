package compiler.tree.types;

/**
 * Created by IntelliJ IDEA.
 * User: NoePodesta
 */


public class StringType extends Type{
    @Override
    public String getName() {
        return "String";
    }

    @Override
    public String getJavaDescriptor() {
        return "(Ljava/lang/String;)";
    }
}
