grammar Calculette;


start
    : calcul EOF;

calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    : 
        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; }
    ;

instruction returns [ String code ] 
    : expression finInstruction 
        { 
            $code = $expression.code;
        }
   | finInstruction
        {
            $code="";
        }
    ;

expression returns [ String code ]
    : a=expression op=('-'|'+') b=expression 
        { 
            $code = $a.code + $b.code;
            $code += $op.text.equals("+") ? "ADD\n" : "SUB\n"; 
        }
    | NUMBER 
        {
            $code = "PUSHI "+$NUMBER.text+"\n";
        }
    ;

finInstruction : ( NEWLINE | ';' )+ ;

// lexer
NEWLINE : '\r'? '\n';

WS :   (' '|'\t')+ -> skip  ;

NUMBER : ('0'..'9')+  ;

UNMATCH : . -> skip ;
