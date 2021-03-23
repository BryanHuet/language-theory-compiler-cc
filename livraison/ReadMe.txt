//au foyer
Compiler la grammaire :

	- export CLASSPATH=".:/usr/share/java/*:$CLASSPATH" (si ça marche pas dans le terminal)
	- java org.antlr.v4.Tool Calculette.g4
	- javac *.java

arbre antler :
	- java org.antlr.v4.runtime.misc.TestRig Calculette start -gui

Commande MVAP :
java MVaPAssembler -d test.mvap
java CBaP -d test.mvap.cbap

//à la fac
Exporter les commandes dans le terminal :
    - export PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/usr/site/bin
    - export CLASSPATH=.:/usr/share/java/stringtemplate4.jar:/usr/share/java/antlr4.jar:/usr/share/java/antlr4-runtime.jar:/usr/share/java/treelayout.jar

executer le script : 
    - tp-compil-autocor Calculette.g4 AdresseType.java TableSymboles.java TablesSymboles.java

--------------------------------------------------------------------------------------------------------------------------
Ce que l'on a fait :
Tous les points ont été réalisés. Et seules les améliorations sur les flotants et les cast de type ont été implentées.

DERNIER TEST EFFECTUE :

Antlr4 ...
Javac
       D00test   compil          assembl         execution       résultat OK
       D01test   compil          assembl
                                   read0         execution       résultat OK
                                   read1         execution       résultat OK
       D02test   compil          assembl         execution       résultat OK
       D03test   compil          assembl         execution       résultat OK
       E01test   compil          assembl         execution       résultat OK
       F01test   compil          assembl         execution       résultat OK
       G01test   compil          assembl         execution       résultat OK
       G02test   compil          assembl         execution       résultat OK
       G03test   compil          assembl         execution       résultat OK
       H01test   compil          assembl         execution       résultat OK
       H02test   compil          assembl
                                   read0         execution       résultat OK
                                   read1         execution       résultat OK
       H03test   compil          assembl
                                   read0         execution       résultat OK
                                   read1         execution       résultat OK
       I01test   compil          assembl
                                   read0         execution       résultat OK
                                   read1         execution       résultat OK
       I02test   compil          assembl         execution       résultat OK
       I03test   compil          assembl         execution       résultat OK
       I04test   compil          assembl
                                   read0         execution       résultat OK
                                   read1         execution       résultat OK
                                   read2         execution       résultat OK
       J01test   compil          assembl         execution       résultat OK
       J02test   compil          assembl         execution       résultat OK
       J03test   compil          assembl         execution       résultat OK
       J04test   compil          assembl         execution       résultat OK
       L01test   compil          assembl         execution       résultat OK
       L02test   compil          assembl         execution       résultat OK
       L03test   compil          assembl         execution       résultat OK
       L04test   compil          assembl         execution       résultat OK
       M01test   compil          assembl
                                   read0         execution       résultat OK
           N01   compil          assembl
                                read1664         execution       résultat OK
                                  read42         execution       résultat OK
           N02   compil          assembl         execution       résultat OK
           N03   compil          assembl         execution       résultat OK
           N04   compil          assembl         execution       résultat OK
      Of01test   compil          assembl
                                    read         execution       résultat OK
      Of02test   compil          assembl         execution       résultat OK
      Of03test   compil          assembl         execution       résultat OK
      Of04test   compil          assembl         execution       résultat OK
      Of05test   compil          assembl         execution       résultat OK
          Of06   compil          assembl         execution       résultat OK
          Of07   compil          assembl         execution       résultat OK
      Ot01test   compil Bug      assembl Bug     execution Bug   résultat KO

Résultat: 142



