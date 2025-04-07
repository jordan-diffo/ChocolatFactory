import ChocolaterieSystem.Chocolaterie;
import ChocolaterieSystem.Chocolatier;

public class Main {
    public static void main(String[] args) {
        // Définir les valeurs par défaut
        int nbChocolatiers = 5;  // Valeur par défaut pour les chocolatiers
        int nbMouleuses = 3;      // Valeur par défaut pour les mouleuses
        int nbTempereuses = 2;    // Valeur par défaut pour les tempéreuses

        // Si des arguments sont passés en ligne de commande, les utiliser
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
            // Afficher les valeurs par défaut utilisées
            System.out.println("Aucun argument passé. Utilisation des valeurs par défaut : ");
            System.out.println("Nombre de chocolatiers : " + nbChocolatiers);
            System.out.println("Nombre de mouleuses : " + nbMouleuses);
            System.out.println("Nombre de tempéreuses : " + nbTempereuses);
        }

        // Créer la chocolaterie avec les paramètres définis
        Chocolaterie chocolaterie = new Chocolaterie(nbMouleuses, nbTempereuses);

        // Créer et lancer les chocolatiers
        for (int i = 0; i < nbChocolatiers; i++) {
            new Chocolatier(i, chocolaterie).start();
        }
    }
}

