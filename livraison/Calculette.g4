grammar Calculette;

@members {
     private int _cur_label = 1;
     /** générateur de nom d'étiquettes pour les boucles */
     private String getNewLabel() { return "B" +(_cur_label++);}

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
bloc_instructs returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    :   (decl { $code += $decl.code; })*

        NEWLINE*

        (instruction { $code += $instruction.code; })*
    ;

instruction returns [ String code ]
    : expression finInstruction
        {
            $code = $expression.code;
            $code += "POP\n";
        }
    | assignation finInstruction
        {
            $code = $assignation.code;
        }

    | condition finInstruction
        {
            $code = $condition.code;
        }

    | methode finInstruction
        {
            $code = $methode.code;
        }

    | finInstruction
        {
            $code="";
            $code += "POP\n";
        }
    ;

decl returns [ String code ]
    : TYPE IDENTIFIANT finInstruction
        {
            tablesSymboles.putVar($IDENTIFIANT.text,"int");
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = "PUSHG "+at.adresse+"\n";
        }
    | TYPE IDENTIFIANT '=' expression finInstruction
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
      ;

methode returns [ String code ]
    : 'read' + '(' IDENTIFIANT ')'
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = "READ\n";
            $code += "STOREG "+at.adresse+"\n";
        }
    | 'write' + '(' expression ')'
        {
            $code = $expression.code;
            $code += "WRITE\n";
            $code += "POP\n";
        }
    | 'while' + '(' a=condition ')' BLOCK_DEBUT b=bloc_instructs BLOCK_END
        {
            String debutB = getNewLabel();
            String finB = getNewLabel();
            $code = "LABEL "+debutB+"\n";
            $code += $a.code;
            $code += "JUMPF "+finB+"\n";
            $code += $b.code;
            $code += "JUMP "+debutB+"\n";
            $code += "LABEL "+finB+"\n";
        }

    | 'while' + '(' ab=condition ')' bb=instruction
        {
            String debutB = getNewLabel();
            String finB = getNewLabel();
            $code = "LABEL "+debutB+"\n";
            $code += $ab.code;
            $code += "JUMPF "+finB+"\n";
            $code += $bb.code;
            $code += "JUMP "+debutB+"\n";
            $code += "LABEL "+finB+"\n";
        }
    | 'if' + '(' condif=condition ')' then=instruction
        {
            String debutIf = getNewLabel();
            String finIf = getNewLabel();
            $code = "LABEL "+debutIf+"\n";
            $code += $condif.code;
            $code += "JUMPF "+finIf+"\n";
            $code += $then.code;
            $code += "LABEL "+finIf+"\n";
        }    
    | 'if' + '(' condifb=condition ')' BLOCK_DEBUT blocif=bloc_instructs BLOCK_END
        {
            String debutIf = getNewLabel();
            String finIf = getNewLabel();
            $code = "LABEL "+debutIf+"\n";
            $code += $condifb.code;
            $code += "JUMPF "+finIf+"\n";
            $code += $blocif.code;
            $code += "LABEL "+finIf+"\n";
        } 
    | 'if' + '(' condifelse=condition ')' BLOCK_DEBUT blocifelse=bloc_instructs BLOCK_END 
        'else' BLOCK_DEBUT blocelse=bloc_instructs BLOCK_END
        {
            String debutIf = getNewLabel();
            String finIf = getNewLabel();
            String finElse = getNewLabel();
            $code = "LABEL "+debutIf+"\n";
            $code += $condifelse.code;
            $code += "JUMPF "+finIf+"\n";
            $code += $blocifelse.code;
            $code += "JUMP "+finElse+"\n";
            $code += "LABEL "+finIf+"\n";
            $code += $blocelse.code;
            $code += "LABEL "+finElse+"\n";

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

    | IDENTIFIANT
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = "PUSHG "+at.adresse+"\n";
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

condition returns [String code]
    : 'true'  { $code = "  PUSHI 1\n"; }
    | 'false' { $code = "  PUSHI 0\n"; }
    | expr1=expression op=('=='|'!='|'<'|'>'|'<='|'>=') expr2=expression
        {
            $code = $expr1.code + $expr2.code;
            if ($op.text.equals("==")){ $code += "EQUAL\n"; }
            else if ($op.text.equals("!=")){ $code += "NEQ\n"; }
            else if ($op.text.equals("<")){ $code += "INF\n"; }
            else if ($op.text.equals(">")){ $code += "SUP\n"; }
            else if ($op.text.equals("<=")){ $code += "INFEQ\n"; }
            else if ($op.text.equals(">=")){ $code += "SUPEQ\n"; }
        }
    | '!' expr3=expression op=('=='|'!='|'<'|'>'|'<='|'>=') expr4=expression
        {
            $code = $expr3.code + $expr4.code;
            if ($op.text.equals("==")){ $code += "NEQ\n"; }
            else if ($op.text.equals("!=")){ $code += "EQUAL\n"; }
            else if ($op.text.equals("<")){ $code += "SUP\n"; }
            else if ($op.text.equals(">")){ $code += "INF\n"; }
            else if ($op.text.equals("<=")){ $code += "SUPEQ\n"; }
            else if ($op.text.equals(">=")){ $code += "INFEQ\n"; }
        }

    | exprA = condition op='&&' exprB = condition
        {
            $code = $exprA.code + $exprB.code;
            $code += "MUL \n";
        }

    | exprC = condition op='||' exprD = condition
        {
            $code = $exprC.code + $exprD.code + "\n";
            $code += "ADD \n";
            $code += "PUSHI 0 \n";
            $code += "SUP \n";
        }

    ;

finInstruction : ( NEWLINE | ';' )+ ;

// lexer
NEWLINE : '\r'? '\n';

TYPE : 'int' | 'float' ;

IDENTIFIANT : ('a'..'z'|'A'..'Z')+;

WS :   (' '|'\t')+ -> skip  ;

NUMBER : ('0'..'9')+  ;

BLOCK_DEBUT: '{';

BLOCK_END: '}';

UNMATCH : . -> skip ;
