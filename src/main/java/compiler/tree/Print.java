package compiler.tree;

import java.util.Stack;

import org.antlr.runtime.Token;

public class Print extends Node {

	public Print(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}
	
	public void execute (Stack<Object> stack) {
		super.execute(stack);
		System.out.println(stack.pop());
	}

}
