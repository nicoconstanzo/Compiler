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
statement: returnStatement|printStatement|declaration|assignStatement|ifStatement|whileStatement|functionStatement;
functionStatement: FUNCTION^ ID L_PARENTHESIS! parameter* R_PARENTHESIS! RETURN! typeSpec IS functionBlock;
functionBlock:  BEGIN^ statement* END!;
functionCall: ID L_PARENTHESIS^ expression* R_PARENTHESIS!
ifStatement: IF^ expression thenBlock elseBlock? END_IF!;
thenBlock: THEN^ statement*;
elseBlock: ELSE^ statement*;
whileStatement: WHILE^ expression loopBlock END_LOOP!;
loopBlock: LOOP^ statement*;
printStatement: PRINT^ expression;
declaration: ID DECLARATION^ typeSpec;
parameter: declaration (COMMA! declaration)?;
assignStatement: ID ASSIGN^ expression;
returnStatement: RETURN^ expression;

typeSpec: INTEGER_TYPE | FLOAT_TYPE | STRING_TYPE | BOOLEAN_TYPE;

/* Expressions */
expression: boolExpr;
boolExpr: compExpr ((AND|OR)^ compExpr)*;
compExpr: addExpr ((GREATER_THAN|LESS_THAN|EQUALS)^ addExpr)*;
addExpr: multExpr((ADD|SUB)^ multExpr)*;
multExpr: factor((MUL|DIV)^ factor)*;

factor: BOOLEAN | STRING | INTEGER | FLOAT | ID |  L_PARENTHESIS! expression R_PARENTHESIS!;

