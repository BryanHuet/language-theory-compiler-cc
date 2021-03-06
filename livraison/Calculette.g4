grammar Calculette;

@members {
    private int _cur_label = 1;
    private int _cur_fonction_label = 1;
     /** générateur de nom d'étiquettes pour les boucles et fonctions */
    private String getNewLabel() { return "B" + (_cur_label++);}
    private String getNewFonctionLabel() { return "F" + (_cur_fonction_label++);}

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
@init{ $code = new String(); }   // On initialise $code, pour ensuite l'utiliser comme accumulateur 
@after{ System.out.println($code); }
    :   (decl { $code += $decl.code; })*        
        { $code += "  JUMP Main\n"; }
        NEWLINE*
        
        (fonction { $code += $fonction.code; })* 
        NEWLINE*
        
        { $code += "LABEL Main\n"; }
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

    | condition finInstruction
        {
            $code = $condition.code;
        }

    | methode 
        {
            $code = $methode.code;
        }

    | RETURN expression finInstruction    
        {
            $code = $expression.code;
            AdresseType at = tablesSymboles.getAdresseType("return");
            if(at.type.equals("float")){
                $code += " STOREL " + (at.adresse+1) + "\n";
                $code += " STOREL " + at.adresse + "\n";
            }else{
                $code += " STOREL " + at.adresse + "\n";
            }
            $code += " RETURN \n";
        }


    | finInstruction
        {
            $code ="";
        }
    ;



fonction returns [ String code ]
@init{  tablesSymboles.newTableLocale(); } // instancier la table locale
@after{ tablesSymboles.dropTableLocale(); } // détruire la table locale
    : TYPE 
        { 
            // code java pour gérer la déclaration de "la variable" de retour de la fonction
            String labelFunction = getNewLabel();
            tablesSymboles.setTypeFunction(labelFunction,$TYPE.text);
            tablesSymboles.putVar("return",$TYPE.text);
        }
        IDENTIFIANT '(' params? ')'
        { 
            // déclarer la nouvelle fonction
            tablesSymboles.newFunction($IDENTIFIANT.text,labelFunction);
            $code = "LABEL "+labelFunction +"\n";
        }
        bloc finInstruction
        {
            // corps de la fonction
            $code += $bloc.code;
        }
    ;

decl returns [ String code ]
    : TYPE IDENTIFIANT finInstruction
        {
            tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            if($TYPE.text.equals("float")){
                $code = "PUSHG " + at.adresse + "\n";
                $code += "PUSHG " + (at.adresse+1) + "\n";
            }else{
                $code = "PUSHG " + at.adresse + "\n";
            }
        }
    | TYPE IDENTIFIANT '=' expression finInstruction
        {
            tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            if (tablesSymboles.getAdresseTypeLocale($IDENTIFIANT.text) == null){
                if($TYPE.text.equals("float")){
                    $code = "PUSHG " + at.adresse + "\n";
                    $code += "PUSHG " + (at.adresse+1) + "\n";
                    $code += $expression.code;
                    $code += "STOREG " + (at.adresse+1) + "\n"; 
                    $code += "STOREG " + at.adresse + "\n";    
                }else{
                    $code = "PUSHG " + at.adresse + "\n";
                    $code += $expression.code;
                    $code += "STOREG " + at.adresse + "\n";
                }
            }else{
                if($TYPE.text.equals("float")){
                    $code = "PUSHL " + at.adresse + "\n";
                    $code += "PUSHL " + (at.adresse+1) + "\n";
                    $code += $expression.code;
                    $code += "STOREL " + (at.adresse+1) + "\n"; 
                    $code += "STOREL " + at.adresse + "\n";    
                }else{
                    $code = "PUSHL " + at.adresse + "\n";
                    $code += $expression.code;
                    $code += "STOREL " + at.adresse + "\n";
                }
            }
        }
    ;
    
params returns [ String code ]
    : TYPE IDENTIFIANT 
        { 
            // code java gérant la déclaration de "la variable" de retour de la fonction
            tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);

        }  
        ( ',' TYPE IDENTIFIANT 
            { 
                // code java gérant une variable locale (argi)
                tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
            } 
        )*
    ;

 // init nécessaire à cause du ? final et donc args peut être vide (mais $args sera non null) 
args returns [ String code, int size] @init{ $code = new String(); $size = 0; }
    : ( expression 
    { 
        // code java pour première expression pour arg
        $code = $expression.code;
        $size = $expression.type.equals("float") ? $size + 2 : $size + 1;

    }
    ( ',' expression 
    { 
        // code java pour expression suivante pour arg
        $code += $expression.code;
        $size = $expression.type.equals("float") ? $size + 2 : $size + 1;
    } 
    )* 
      )? 
    ;

bloc returns [String code] @init{ $code = new String(); } 
    : '{' ( instruction { $code += $instruction.code; } )+ '}' NEWLINE
    | '{' ( instruction { $code += $instruction.code; } )+ '}'
    ;   

assignation returns [ String code ]
    : IDENTIFIANT '=' expression
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            if (tablesSymboles.getAdresseTypeLocale($IDENTIFIANT.text) == null){
                if(at.type.equals("float")){
                    $code = $expression.code;
                    $code += "STOREG " + (at.adresse+1) + "\n";
                    $code += "STOREG " + at.adresse + "\n";
                }else{
                    $code = $expression.code;
                    $code += "STOREG " + at.adresse + "\n";
                }
            }else{
                if(at.type.equals("float")){
                    $code = $expression.code;
                    $code += "STOREL " + (at.adresse+1) + "\n";
                    $code += "STOREL " + at.adresse + "\n";
                }else{
                    $code = $expression.code;
                    $code += "STOREL " + at.adresse + "\n";
                }
            }
        }
    | TYPE IDENTIFIANT '=' expression
        {
            tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            if (tablesSymboles.getAdresseTypeLocale($IDENTIFIANT.text) == null){
                if($TYPE.text.equals("float")){
                    $code = "PUSHG " + at.adresse + "\n";
                    $code += "PUSHG " + (at.adresse+1) + "\n";
                    $code += $expression.code;
                    $code += "STOREG " + (at.adresse+1) + "\n"; 
                    $code += "STOREG " + at.adresse + "\n";    
                }else{
                    $code = "PUSHG " + at.adresse + "\n";
                    $code += $expression.code;
                    $code += "STOREG " + at.adresse + "\n";
                }
            }else{
                if($TYPE.text.equals("float")){
                    $code = "PUSHL " + at.adresse + "\n";
                    $code += "PUSHL " + (at.adresse+1) + "\n";
                    $code += $expression.code;
                    $code += "STOREL " + (at.adresse+1) + "\n";
                    $code += "STOREL " + at.adresse + "\n";     
                }else{
                    $code = "PUSHL " + at.adresse + "\n";
                    $code += $expression.code;
                    $code += "STOREL " + at.adresse + "\n";
                }
            }
        }
      ;

methode returns [ String code ]
    : 'read' '(' IDENTIFIANT ')'
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            if(at.type.equals("float")){
                $code = "READF\n";
                $code += "STOREG "+ (at.adresse+1)+"\n";
                $code += "STOREG "+ at.adresse+"\n";
            }else{
                $code = "READ\n";
                $code += "STOREG "+ at.adresse+"\n";
            }

        }    

    | 'write' '(' expression ')'
        {
            $code = $expression.code;
            if($expression.type.equals("float")){
               $code += "WRITEF\n"; 
               $code += "POP\n";
               $code += "POP\n";
            }else{
                $code += "WRITE\n";
                $code += "POP\n";
            }
        }
    | 'while' '(' a=condition ')' b=bloc 
        {
            $code = loopWhile($a.code, $b.code);
        }

    | 'while' '(' ab=condition ')' bb=instruction
        {
            $code = loopWhile($ab.code, $bb.code);
        }
    | 'for' '(' forAssB = assignation ';' forCondB = condition ';' forAssbB = assignation ')'
         forInB = bloc
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


    | 'repeat' bloc_instructs = bloc 'until' '(' condition ')'
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
    | 'if' '(' condifelse = condition ')'  blocifelse = bloc 
         ( NEWLINE 'else' | 'else' )  blocelse = bloc 
        {
            $code = ifThenElse($condifelse.code, $blocifelse.code, $blocelse.code);
        }
    | 'if' '(' condifbB = condition ')'   blocifB = bloc 
         ( NEWLINE 'else' | 'else' )  elseinstruc = instruction
        {
            $code = ifThenElse($condifbB.code, $blocifB.code, $elseinstruc.code);
        } 

    | 'if' '(' condifE = condition ')' thenE = instruction 
         ( NEWLINE 'else' | 'else' ) elseE = instruction 
        {
            $code = ifThenElse($condifE.code, $thenE.code, $elseE.code);
        }  
    | 'if' '(' condif = condition ')' then = instruction
        {
            $code = ifThenElse($condif.code, $then.code, "null");
        }    
    | 'if' '(' condifb = condition ')'   blocif = bloc 
        {
            $code = ifThenElse($condifb.code, $blocif.code, "null");
        } 



    ;

expression returns [ String code, String type ]
    : '(' expression ')'
        {
            $type = $expression.type;
            $code = $expression.code;
        }
    | '(' a=expression op=('-'|'+') b=expression ')'
        {
            if ($a.type.equals($b.type)){
                $type = $a.type;
            }
            $code = $a.code + $b.code;        
            if($a.type.equals("float") && $b.type.equals("float")){
                $code += $op.text.equals("+") ? "FADD\n" : "FSUB\n";
            }else{
                $code += $op.text.equals("+") ? "ADD\n" : "SUB\n";
            }
        }

    | '(' a=expression op=('*'|'/') b=expression ')' {
        if ($a.type.equals($b.type)){
            $type = $a.type;
        }
        $code = $a.code + $b.code;
        if($type.equals("float")){
            $code += $op.text.equals("*") ? "FMUL\n" : "FDIV\n";
        }else{
            $code += $op.text.equals("*") ? "MUL\n" : "DIV\n";
        }
    }


    | a=expression op=('*'|'/') b=expression {
        if ($a.type.equals($b.type)){
            $type = $a.type;
        }
        $code = $a.code + $b.code;
        if($type.equals("float")){
            $code += $op.text.equals("*") ? "FMUL\n" : "FDIV\n";
        }else{
            $code += $op.text.equals("*") ? "MUL\n" : "DIV\n";
        }
    }

    | a=expression op=('-'|'+') b=expression
        {
            if ($a.type.equals($b.type)){
                $type = $a.type;
            }       
            $code = $a.code + $b.code;        
            if($a.type.equals("float") && $b.type.equals("float")){
                $code += $op.text.equals("+") ? "FADD\n" : "FSUB\n";
            }else{
                $code += $op.text.equals("+") ? "ADD\n" : "SUB\n";
            }
        }



    | IDENTIFIANT '(' args ')'                  // appel de fonction  c'est ici le CALL
        {  
            $type = tablesSymboles.getTypeFunction(tablesSymboles.getFunction($IDENTIFIANT.text));
            if($type.equals("float")){
                $code = "PUSHI 0\n"; 
                $code += "PUSHI 0\n"; 
            }else {
                $code = "PUSHI 0\n";
            }
            $code += $args.code; // on empile les arguments
            $code += "CALL " + tablesSymboles.getFunction($IDENTIFIANT.text) + "\n";
            for(int i = 0; i < $args.size; i++){
                $code += "POP\n";
            }
        }

    | '(' TYPE ')' expression
        {
            if ($TYPE.text.equals("int")){
                    $code = $expression.code;
                    $code += "FTOI\n";
                    $type = "int";
            }else{
                    $code = $expression.code;
                    $code += "ITOF\n";
                    $type = "float";
            }
        }

    | IDENTIFIANT
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            if(tablesSymboles.getAdresseTypeLocale($IDENTIFIANT.text) == null){
                if(at.type.equals("float")){
                    $type = "float";
                    $code = "PUSHG " + at.adresse + "\n";
                    $code += "PUSHG " + (at.adresse+1) + "\n"; 
                }else {
                    $type = "int";
                    $code = "PUSHG " + at.adresse + "\n";
                }
            }else{
                if(at.type.equals("float")){
                    $type = "float";
                    $code = "PUSHL " + at.adresse + "\n";
                    $code += "PUSHL " + (at.adresse+1) + "\n"; 
                }else {
                    $type = "int";
                    $code = "PUSHL " + at.adresse + "\n";
                }
            }
        }


    | unite=NUMBER '.' decimal=NUMBER
        { 
            $type = "float";
            $code = "PUSHF " + $unite.text + "." + $decimal.text + "\n";
        }
    | unite=NUMBER '.'
        { 
            $type = "float";
            $code = "PUSHF " + $unite.text + ".0" + "\n";
        }
    | '-' NUMBER
     {
         $type = "int";
         $code = "PUSHI -"+$NUMBER.text+"\n";
     }
    | NUMBER
        {
            $type = "int";
            $code = "PUSHI "+$NUMBER.text+"\n";
        }
    ;

condition returns [String code]
    : 'true'  { $code = "  PUSHI 1\n"; }
    | 'false' { $code = "  PUSHI 0\n"; }
    | '! true' {$code = " PUSHI 0\n"; }
    | '! false' {$code = " PUSHI 1\n"; }
    | expr1=expression op=('=='|'!='|'<'|'>'|'<='|'>=') expr2=expression
        {
            if($expr1.type.equals("float")){
                $code = $expr1.code + $expr2.code;
                if ($op.text.equals("==")){ $code += "FEQUAL\n"; }
                else if ($op.text.equals("!=")){ $code += "FNEQ\n"; }
                else if ($op.text.equals("<")){ $code += "FINF\n"; }
                else if ($op.text.equals(">")){ $code += "FSUP\n"; }
                else if ($op.text.equals("<=")){ $code += "FINFEQ\n"; }
                else if ($op.text.equals(">=")){ $code += "FSUPEQ\n"; }
            }else{
                $code = $expr1.code + $expr2.code;
                if ($op.text.equals("==")){ $code += "EQUAL\n"; }
                else if ($op.text.equals("!=")){ $code += "NEQ\n"; }
                else if ($op.text.equals("<")){ $code += "INF\n"; }
                else if ($op.text.equals(">")){ $code += "SUP\n"; }
                else if ($op.text.equals("<=")){ $code += "INFEQ\n"; }
                else if ($op.text.equals(">=")){ $code += "SUPEQ\n"; }
            }
        }
    | '!' expr3=expression op=('=='|'!='|'<'|'>'|'<='|'>=') expr4=expression
        {
            if($expr3.type.equals("float")){
                $code = $expr3.code + $expr4.code;
                if ($op.text.equals("==")){ $code += "FNEQ\n"; }
                else if ($op.text.equals("!=")){ $code += "FEQUAL\n"; }
                else if ($op.text.equals("<")){ $code += "FSUP\n"; }
                else if ($op.text.equals(">")){ $code += "FINF\n"; }
                else if ($op.text.equals("<=")){ $code += "FSUPEQ\n"; }
                else if ($op.text.equals(">=")){ $code += "FINFEQ\n"; }
            
            
            }else{
                $code = $expr3.code + $expr4.code;
                if ($op.text.equals("==")){ $code += "NEQ\n"; }
                else if ($op.text.equals("!=")){ $code += "EQUAL\n"; }
                else if ($op.text.equals("<")){ $code += "SUP\n"; }
                else if ($op.text.equals(">")){ $code += "INF\n"; }
                else if ($op.text.equals("<=")){ $code += "SUPEQ\n"; }
                else if ($op.text.equals(">=")){ $code += "INFEQ\n"; }
            }
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

RETURN: 'return' ;

TYPE : 'int' | 'float' ;

IDENTIFIANT : ('a'..'z' | 'A'..'Z')('a'..'z'|'0'..'9')* ;

NUMBER : ('0'..'9')+  ;

COMMENT
: '/*' .*? '*/' -> skip;

COMMENT_INLINE
: '//' ~( '\r' | '\n' )* -> skip;

UNMATCH : . -> skip ;
