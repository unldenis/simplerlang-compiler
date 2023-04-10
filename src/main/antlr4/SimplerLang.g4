grammar SimplerLang;

program : statement* ;

statement : let | print ;

let : VAR '=' NUMBER ;
print : 'print' (NUMBER | VAR) ;

VAR : [a-zA-Z] [a-zA-Z0-9]* ;
NUMBER: [0-9]+ ;
WS : [ \n\t\r]+ -> skip;