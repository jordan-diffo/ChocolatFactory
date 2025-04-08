Ce projet simule le fonctionnement concurrent d’une chocolaterie où plusieurs chocolatiers partagent des tempéreuses et des mouleuses limitées.
Des ruptures simulées peuvent empêcher temporairement l’accès à certaines ressources.

* Prérequis
- Java 21 ou version ultérieure
- Aucun framework ou bibliothèque externe requis

* Exécution
- Simulation :
Deux modes de simulation sont possibles :

  1- Simulation avec paramétrage du nombre de chocolatiers, mouleuses et tempéreuses
Le nombre de chocolatiers, mouleuses et tempéreuses peut être modifié via les arguments en ligne de commande.
Dans le terminal, exécuter les commandes :
<< cd src >>
<< java Main.java [nbChocolatiers] [nbMouleuses] [nbTempereuses] >>  (s'assurer d'être dans le répertoire "src" avant d'exécuter cette commande)

Par exemple, pour une simulation avec 5 chocolatiers, 3 mouleuses et 2 tempéreuses, exécuter les commandes 
<< cd src >>
<< java Main.java 5 3 2 >> 

  2- Simulation avec des valeurs par défaut de nombre de chocolatiers, mouleuses et tempéreuses
Si aucun argument n’est fourni, les valeurs par défaut suivantes sont utilisées
5 chocolatiers, 3 mouleuses, 2 tempéreuses
Pour faire une simuler par défaut, il suffit de lancer directement main.java


* Exemple de simulation (avec paramétrage du nombre de chocolatiers, mouleuses et tempéreuses)

cd src
java Main.java 5 2 1
Utilisation des valeurs en ligne de commande : 
Nombre de chocolatiers : 3
Nombre de mouleuses : 2
Nombre de tempéreuses : 1
Chocolatier 1 attend une tempéreuse...
Chocolatier 2 attend une tempéreuse...
Chocolatier 0 attend une tempéreuse...
Toutes les tempéreuses sont occupées. Chocolatier 0 attend...
Toutes les tempéreuses sont occupées. Chocolatier 2 attend...
Chocolatier 1 a obtenu la tempéreuse T1
Chocolatier 1 tempère le chocolat blanc.
Chocolatier 1 donne le chocolat.
Chocolatier 0 a finalement obtenu la tempéreuse T1
Chocolatier 0 tempère le chocolat noir.
Chocolatier 1 a libéré la tempéreuse T1 !
Chocolatier 1 tente d'obtenir une mouleuse...
Chocolatier 1 a obtenu la mouleuse M1
Chocolatier 1 remplit le moule.
Chocolatier 0 donne le chocolat.
Chocolatier 2 a finalement obtenu la tempéreuse T1
Chocolatier 2 tempère le chocolat noir.
Chocolatier 0 a libéré la tempéreuse T1 !
Chocolatier 0 tente d'obtenir une mouleuse...
Chocolatier 0 a obtenu la mouleuse M2
Chocolatier 0 remplit le moule.
Moule rempli.
Chocolatier 1 garnit le moule.
Chocolatier 2 donne le chocolat.
Moule garni.
Chocolatier 1 ferme le moule.
Moule rempli.
Chocolatier 0 garnit le moule.
Chocolatier 2 a libéré la tempéreuse T1 !
Chocolatier 2 tente d'obtenir une mouleuse...
Toutes les mouleuses sont occupées. Chocolatier 2 attend...
Moule fermé.
Chocolatier 1 a libéré la mouleuse M1 !
Chocolatier 2 a obtenu la mouleuse M1
Chocolatier 2 remplit le moule.
Moule garni.
Chocolatier 0 ferme le moule.
Moule fermé.
Chocolatier 0 a libéré la mouleuse M1 !
Moule rempli.
Chocolatier 2 garnit le moule.
Moule garni.
Chocolatier 2 ferme le moule.
Moule fermé.
Chocolatier 2 a libéré la mouleuse M2 !


