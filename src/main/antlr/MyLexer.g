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
GREATER_THAN:'>';
LESS_THAN:'<';
EQUALS:'==';
AND:'&';
OR:'|';
IF:'if';
ELSE: 'else';
THEN: 'then';
END_IF: 'end if';
WHILE:'while';
LOOP: 'loop';
END_LOOP:'end loop';

/* Operators */
ADD:'+';
SUB:'-';
MUL:'*';
DIV:'/';

/*  Types */
INTEGER_TYPE: 'Integer';
FLOAT_TYPE: 'Float';
STRING_TYPE: 'String';
BOOLEAN_TYPE: 'Boolean';

/* Strings */
STRING: QUOTE! (~'"')* QUOTE!;
QUOTE: '"';

/* Boolean */
BOOLEAN: 'true' | 'false';


/* Identifier */
ID: LETTER (LETTER|DIGIT)*;
fragment LETTER: 'a'..'z' | 'A'..'Z';
	
/* Numbers */
INTEGER: DIGIT+;
fragment DIGIT: '0'..'9';
FLOAT: INTEGER '.' INTEGER;
L_PARENTHESIS:'(';
R_PARENTHESIS:')';






