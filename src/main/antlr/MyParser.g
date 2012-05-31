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
statement: printStatement|declarationStatement|assignStatement|ifStatement|whileStatement;
ifStatement: IF^ expression thenBlock elseBlock? END_IF!;
thenBlock: THEN^ statement*;
elseBlock: ELSE^ statement*;
whileStatement: WHILE^ expression loopBlock END_LOOP!;
loopBlock: LOOP^ statement*;
printStatement: PRINT^ expression;
declarationStatement: ID DECLARATION^ typeSpec;
assignStatement: ID ASSIGN^ expression;

typeSpec: INTEGER_TYPE | FLOAT_TYPE | STRING_TYPE | BOOLEAN_TYPE;

/* Expressions */
expression: boolExpr;
boolExpr: compExpr ((AND|OR)^ compExpr)*;
compExpr: addExpr ((GREATER_THAN|LESS_THAN|EQUALS)^ addExpr)*;
addExpr: multExpr((ADD|SUB)^ multExpr)*;
multExpr: factor((MUL|DIV)^ factor)*;

factor: BOOLEAN | STRING | INTEGER | FLOAT | ID |  L_PARENTHESIS! expression R_PARENTHESIS!;

