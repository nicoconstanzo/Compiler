lexer grammar MyLexer;

@header {
    package compiler;
}

/* Whitespaces */
WHITESPACE: (' '|'\t'|'\n'|'\r') + {skip();} ;

/* Reserved words */
PRINT:'print';
ASSIGN:':=';
DECLARATION:':';

/* Operators */
ADD:'+';
SUB:'-';
MUL:'*';
DIV:'/';

/*  Types */
INTEGER_TYPE: 'Integer';
FLOAT_TYPE: 'Float';
STRING_TYPE: 'String';

/* Strings */
STRING: QUOTE (~'"')* QUOTE;
QUOTE: '"';


/* Identifier */
ID: LETTER (LETTER|DIGIT)*;
fragment LETTER: 'a'..'z' | 'A'..'Z';
	
/* Numbers */
INTEGER: DIGIT+;
fragment DIGIT: '0'..'9';
FLOAT: INTEGER '.' INTEGER;
L_PARENTHESIS:'(';
R_PARENTHESIS:')';






