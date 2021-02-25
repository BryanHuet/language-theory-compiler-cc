grammar Calculette;

@members {
     private TablesSymboles tablesSymboles = new TablesSymboles();
          }



//parser
start
    : calcul EOF;

calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    :   (decl { $code += $decl.code; })*

        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; }
    ;

instruction returns [ String code ]
    : expression finInstruction
        {
            $code = $expression.code;
        }
    | assignation finInstruction
        {
            $code = $assignation.code;
        }

   | finInstruction
        {
            $code="";
        }
    ;

decl returns [ String code ]
    :
        TYPE IDENTIFIANT finInstruction
        {
            tablesSymboles.putVar($IDENTIFIANT.text,"int");
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = "PUSHG "+at.adresse+"\n";
        }
    | TYPE IDENTIFIANT '=' expression
        {
            tablesSymboles.putVar($IDENTIFIANT.text,"int");
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = "PUSHG "+at.adresse+"\n";
            $code += $expression.code;
            $code += "STOREG "+at.adresse+"\n";
        }
    ;

assignation returns [ String code ]
    : IDENTIFIANT '=' expression
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = $expression.code;
            $code += "STOREG "+at.adresse+"\n";
        }
    | IDENTIFIANT '*' expression
        {

            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = $expression.code;
            $code += "MUL\n";
            $code += "STOREG "+at.adresse+"\n";
        }
    | IDENTIFIANT '/' expression
            {

                AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
                $code = $expression.code;
                $code += "DIV\n";
                $code += "STOREG "+at.adresse+"\n";
            }
    | IDENTIFIANT '+' expression
        {

            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = $expression.code;
            $code += "ADD\n";
            $code += "STOREG "+at.adresse+"\n";
        }
    | IDENTIFIANT '-' expression
            {

                AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
                $code = $expression.code;
                $code += "SUB\n";
                $code += "STOREG "+at.adresse+"\n";
            }
      ;

expression returns [ String code ]
    : '(' a=expression op=('-'|'+') b=expression ')'
        {
            $code = $a.code + $b.code;
            $code += $op.text.equals("+") ? "ADD\n" : "SUB\n";
        }

    | '(' a=expression op=('*'|'/') b=expression ')' {
        $code = $a.code + $b.code;
        $code += $op.text.equals("*") ? "MUL\n" : "DIV\n";
    }

    | a=expression op=('*'|'/') b=expression {
        $code = $a.code + $b.code;
        $code += $op.text.equals("*") ? "MUL\n" : "DIV\n";
    }

    | a=expression op=('-'|'+') b=expression
        {
            $code = $a.code + $b.code;
            $code += $op.text.equals("+") ? "ADD\n" : "SUB\n";
        }
    | op=('(-'|'(') NUMBER ')'
    {
        $code = $op.text.equals("(-") ? "PUSHI -"+$NUMBER.text+"\n" : "PUSHI "+$NUMBER.text+"\n";
    }

    | '-' NUMBER
     {
         $code = "PUSHI -"+$NUMBER.text+"\n";
     }
    | NUMBER
        {
            $code = "PUSHI "+$NUMBER.text+"\n";
        }
    ;



finInstruction : ( NEWLINE | ';' )+ ;



// lexer
NEWLINE : '\r'? '\n';

TYPE : 'int' | 'float' ;

IDENTIFIANT : ('a'..'z'|'A'..'Z')+ ;

WS :   (' '|'\t')+ -> skip  ;

NUMBER : ('0'..'9')+  ;

UNMATCH : . -> skip ;
