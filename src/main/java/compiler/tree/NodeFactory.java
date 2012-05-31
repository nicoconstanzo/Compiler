package compiler.tree;

import compiler.MyLexer;

import compiler.tree.booleanLogic.Equals;
import compiler.tree.booleanLogic.GreaterThan;
import compiler.tree.booleanLogic.LessThan;
import compiler.tree.controlStructure.*;
import compiler.tree.literals.LiteralBoolean;
import compiler.tree.literals.LiteralFloat;
import compiler.tree.literals.LiteralInteger;
import compiler.tree.literals.LiteralString;
import compiler.tree.operations.*;
import compiler.tree.values.*;
import org.antlr.runtime.Token;

public class NodeFactory {
    public static Node create(Token token) {
        Node node;

        if (token == null) {
            node = new Node(null);
        } else {
            switch (token.getType()) {
                case MyLexer.ADD:
                    node = new Add(token);
                    break;
                case MyLexer.SUB:
                    node = new Sub(token);
                    break;
                case MyLexer.MUL:
                    node = new Mul(token);
                    break;
                case MyLexer.DIV:
                    node = new Div(token);
                    break;
                case MyLexer.GREATER_THAN:
                    node = new GreaterThan(token);
                    break;
                case MyLexer.LESS_THAN:
                    node = new LessThan(token);
                    break;
                case MyLexer.ID:
                    node = new Id(token);
                    break;
                case MyLexer.INTEGER:
                    node = new IntValue(token);
                    break;
                case MyLexer.INTEGER_TYPE:
                    node = new LiteralInteger(token);
                    break;
                case MyLexer.FLOAT:
                    node = new FloatValue(token);
                    break;
                case MyLexer.FLOAT_TYPE:
                    node = new LiteralFloat(token);
                    break;
                case MyLexer.STRING:
                    node = new StringValue(token);
                    break;
                case MyLexer.STRING_TYPE:
                    node = new LiteralString(token);
                    break;
                case MyLexer.BOOLEAN:
                    node = new BooleanValue(token);
                    break;
                case MyLexer.BOOLEAN_TYPE:
                    node = new LiteralBoolean(token);
                    break;
                case MyLexer.EQUALS:
                    node = new Equals(token);
                    break;
                case MyLexer.PRINT:
                    node = new Print(token);
                    break;
                case MyLexer.ASSIGN:
                    node = new Assign(token);
                    break;
                case MyLexer.DECLARATION:
                    node = new Declaration(token);
                    break;
                case MyLexer.IF:
                    node = new If(token);
                    break;
                case MyLexer.THEN:
                    node = new Block(token);
                    break;
                case MyLexer.ELSE:
                    node = new Block(token);
                    break;
                case MyLexer.LOOP:
                    node = new Block(token);
                    break;
                case MyLexer.WHILE:
                    node = new While(token);
                    break;

                case MyLexer.EOF:
                    node = new Program(token);
                    break;


                default:
                    node = new Node(token);
            }
        }


        return node;
    }
}
