import ChocolaterieSysteme.Chocolaterie;
import ChocolaterieSysteme.Chocolatier;

public class Main {
    public static void main(String[] args) {
        int nbChocolatiers = 5;  // Valeur par défaut pour les chocolatiers
        int nbMouleuses = 3;      // Valeur par défaut pour les mouleuses
        int nbTempereuses = 2;    // Valeur par défaut pour les tempéreuses

        // Utilisation des arguments passés en ligne de commande si c'est le cas
        if (args.length == 3) {
            try {
                nbChocolatiers = Integer.parseInt(args[0]);
                nbMouleuses = Integer.parseInt(args[1]);
                nbTempereuses = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Les arguments doivent être des nombres entiers.");
                return;
            }
        } else {
            // Affichage les valeurs par défaut utilisées
            System.out.println("Aucun argument passé. Utilisation des valeurs par défaut : ");
            System.out.println("Nombre de chocolatiers : " + nbChocolatiers);
            System.out.println("Nombre de mouleuses : " + nbMouleuses);
            System.out.println("Nombre de tempéreuses : " + nbTempereuses);
        }

        System.out.println("Utilisation des valeurs en ligne de commande: ");
        System.out.println("Nombre de chocolatiers : " + nbChocolatiers);
        System.out.println("Nombre de mouleuses : " + nbMouleuses);
        System.out.println("Nombre de tempéreuses : " + nbTempereuses);
        // Création de la chocolaterie avec les paramètres définis
        Chocolaterie chocolaterie = new Chocolaterie(nbMouleuses, nbTempereuses);

        for (int i = 0; i < nbChocolatiers; i++) {
            new Chocolatier(i, chocolaterie).start();
        }
    }
}

