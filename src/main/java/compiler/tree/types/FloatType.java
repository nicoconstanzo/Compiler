package compiler.tree.types;

public class FloatType extends Type {

	@Override
	public String getName() {		
		return "Float";
	}

    @Override
    public String getJavaDescriptor() {
        return "(F)";
    }

}
