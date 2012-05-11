package compiler.tree.types;

public class IntType extends Type {

	@Override
	public String getName() {
		return "Integer";
	}

    @Override
    public String getJavaDescriptor() {
        return "(I)";

    }

}
