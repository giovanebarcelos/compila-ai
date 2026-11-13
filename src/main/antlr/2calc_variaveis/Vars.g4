// 05 - Calculadora com variáveis: atribuição, print, ^ associativo à direita.

grammar Vars;

programa : comando* EOF;

comando  : ID '=' expr ';'  # Atribuicao
           | PRINT expr ';' # Imprime
           ;

expr     : <assoc=right> expr '^' expr      # Potencia  // 2^3^2 = 2^(3^2)
           | '-' expr                       # Negativo  // -2^2 = -(2^2)
           | expr op=('*'|'/'|'%') expr     # MulDiv
           | expr op=('+'|'-') expr         # SomaSub
           | NUM                            # Numero
           | ID                             # Variavel
           | '(' expr ')'                   # Parenteses
           ;

PRINT      : 'print' ;
ID         : [a-zA-Z_][a-zA-Z_0-9]* ;
NUM        : [0-9]+('.'[0-9]+)? ;
COMENTARIO : '#'~[\r\n]* -> skip ;
WS         : [ \t\r\n]+ -> skip ;
