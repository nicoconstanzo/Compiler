parser grammar MyParser;

options {
    output = AST;
    tokenVocab = MyLexer;
    ASTLabelType = Node;
}

@header {
    package compiler;
    import compiler.tree.*;
}

program: statement* EOF^;
	
/* Statements*/
statement: printStatement|declarationStatement|assignStatement;
printStatement: PRINT^ expression;
declarationStatement: ID DECLARATION^ typeSpec;
assignStatement: ID ASSIGN^ expression;

typeSpec: INTEGER_TYPE | FLOAT_TYPE | STRING_TYPE;

/* Expressions */
expression: addExpr;
addExpr: multExpr((ADD|SUB)^ multExpr)*;
multExpr: factor((MUL|DIV)^ factor)*;
factor: STRING | INTEGER | FLOAT | ID |  L_PARENTHESIS! expression R_PARENTHESIS!;


