package compiler.tree.types;

public abstract class Type {

	public abstract String getName();
	public static final Type INTEGER = new IntType();
	public static final Type FLOAT = new FloatType();
    public static final Type STRING = new StringType();
    public static final Type BOOLEAN = new BooleanType();


    public static Type promotion(Type t1, Type t2){
        
        if(t1 == STRING || t2 == STRING){
             return Type.STRING;
        }

        else if(t1 == FLOAT || t2  == FLOAT){
         return Type.FLOAT;

        }
        else{
            return Type.INTEGER;
        }
        
        
    }

    public boolean isInteger() {
        return equals(INTEGER);
    }


    public boolean isString() {
        return equals(STRING);
    }

    public boolean isFloat() {
        return equals(FLOAT);
    }

    public boolean isBoolean() {
           return equals(BOOLEAN);
       }

    public abstract String getJavaDescriptor();
}
                    