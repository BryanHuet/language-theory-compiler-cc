grammar Calculette;

@members {
    private int _cur_label = 1;
     /** générateur de nom d'étiquettes pour les boucles */
    private String getNewLabel() { return "B" + (_cur_label++);}

    private TablesSymboles tablesSymboles = new TablesSymboles();

    private String loopWhile(String conditions, String instructions){
        String debutB = getNewLabel();
        String finB = getNewLabel();
        String code = "LABEL "+debutB+"\n";
        code += conditions;
        code += "JUMPF "+finB+"\n";
        code += instructions;
        code += "JUMP "+debutB+"\n";
        code += "LABEL "+finB+"\n";
        return code;
    }

    private String ifThenElse(String conditions, String instructions, String instructElse){

            String finIf = getNewLabel();
            String finElse = getNewLabel();
            String code = "";
            code += conditions;
            code += "JUMPF " + finIf + "\n";
            code += instructions;
            if(instructElse != "null"){
                code += "JUMP " + finElse + "\n";
                code += "LABEL " + finIf + "\n";
                code += instructElse;
                code += "LABEL " + finElse + "\n";
            }else{
                code += "LABEL " + finIf + "\n";
            }

            return code;
    }


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
            $code ="";
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
    ;
bloc returns [String code] @init{ $code = new String(); } 
    : ( instruction { $code += $instruction.code; } )+
    ;   

assignation returns [ String code ]
    : IDENTIFIANT '=' expression
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = $expression.code;
            $code += "STOREG "+at.adresse+"\n";
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

methode returns [ String code ]
    : 'read' '(' IDENTIFIANT ')'
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            $code = "READ\n";
            $code += "STOREG "+ at.adresse+"\n";
        }
    | 'write' '(' expression ')'
        {
            $code = $expression.code;
            $code += "WRITE\n";
            $code += "POP\n";
        }
    | 'while' '(' a=condition ')' '{' b=bloc '}'
        {
            $code = loopWhile($a.code, $b.code);
        }

    | 'while' '(' ab=condition ')' bb=instruction
        {
            $code = loopWhile($ab.code, $bb.code);
        }
    | 'for' '(' forAssB = assignation ';' forCondB = condition ';' forAssbB = assignation ')'
         '{' forInB = instruction '}'
        {
            String debutFor = getNewLabel();
            String finFor = getNewLabel();
            $code = $forAssB.code;
            $code += "LABEL " + debutFor + "\n";
            $code += $forCondB.code;
            $code += "JUMPF " + finFor + "\n";
            $code += $forInB.code;
            $code += $forAssbB.code;
            $code += "JUMP " + debutFor + "\n";
            $code += "LABEL " + finFor + "\n";
        }
    
    | 'for' '(' forAss=assignation ';' forCond=condition ';' forAssb=assignation ')' forIn=instruction
        {
            String debutFor = getNewLabel();
            String finFor = getNewLabel();
            $code = $forAss.code;
            $code += "LABEL " + debutFor + "\n";
            $code += $forCond.code;
            $code += "JUMPF " + finFor + "\n";
            $code += $forIn.code;
            $code += $forAssb.code;
            $code += "JUMP " + debutFor + "\n";
            $code += "LABEL " + finFor + "\n";
        }


    | 'repeat' '{' bloc_instructs=instruction+ '}' 'until' '(' condition ')'
        {
            String debutReapeat = getNewLabel();
            $code = "LABEL " + debutReapeat + "\n";
            $code += $bloc_instructs.code;
            $code += $condition.code;
            $code += "JUMPF " + debutReapeat + "\n";

        }     

    | 'repeat' instruction 'until' '(' condition ')'
        {
            String debutReapeat = getNewLabel();
            $code = "LABEL " + debutReapeat + "\n";
            $code += $instruction.code;
            $code += $condition.code;
            $code += "JUMPF " + debutReapeat + "\n";

        }     
    | 'if' '(' condifelse = condition ')' '{' blocifelse = bloc '}'
         'else'  '{' blocelse = bloc '}'
        {
            $code = ifThenElse($condifelse.code, $blocelse.code, $blocelse.code);
        } 
    | 'if' '(' condifbB = condition ')' '{'  blocifB = bloc '}'
         'else'  elseinstruc = instruction
        {
            $code = ifThenElse($condifbB.code, $blocifB.code, $elseinstruc.code);
        } 
    | 'if' '(' condifb = condition ')' '{'  blocif = bloc '}'
        {
            $code = ifThenElse($condifb.code, $blocif.code, "null");
        } 
    | 'if' '(' condifE = condition ')' thenE = instruction 
         'else' elseE = instruction 
        {
            $code = ifThenElse($condifE.code, $thenE.code, $elseE.code);
        }  
    | 'if' '(' condif = condition ')' then = instruction
        {
            $code = ifThenElse($condif.code, $then.code, "null");
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

WS :   (' '|'\t')+ -> skip  ;

TYPE : 'int' | 'float' ;

IDENTIFIANT :[a-z]+;

NUMBER : ('0'..'9')+  ;

COMMENT : '/*' .*? '*/'-> skip;

UNMATCH : . -> skip ;
