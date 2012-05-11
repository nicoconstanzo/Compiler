package compiler.tree.values;

import java.util.Stack;

import compiler.tree.Node;
import compiler.tree.symbol.SymbolTable;
import compiler.tree.types.Type;
import org.antlr.runtime.Token;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class IntValue extends Node {
	
	public IntValue(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void analyze(SymbolTable symbolTable) {
        setTypeDef(Type.INTEGER);
    }


    @Override
    public void execute (Stack<Object> stack) {
		stack.push(Integer.parseInt(getText()));
	}

    @Override
    public void generateBytecode(MethodVisitor mv) {
        super.generateBytecode(mv);
        if(-127<=Integer.parseInt(getText()) && Integer.parseInt(getText())<=128){
            mv.visitIntInsn(Opcodes.BIPUSH, Integer.parseInt(getText()));
        }else{
            mv.visitIntInsn(Opcodes.SIPUSH, Integer.parseInt(getText()));
        };
    }

}
