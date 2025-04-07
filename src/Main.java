import ChocolaterieSystem.Chocolaterie;
import ChocolaterieSystem.Chocolatier;

public class Main {
    public static void main(String[] args) {
        int nbChocolatiers = 5; // Valeur par défaut
        int nbMouleuses = 2; // Valeur par défaut
        int nbTempereuses = 2; // Valeur par défaut

        // Vérification des arguments passés en ligne de commande
        if (args.length >= 1) {
            try {
                nbChocolatiers = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Le nombre de chocolatiers doit être un entier valide.");
            }
        }
        if (args.length >= 2) {
            try {
                nbMouleuses = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Le nombre de mouleuses doit être un entier valide.");
            }
        }
        if (args.length >= 3) {
            try {
                nbTempereuses = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Le nombre de tempéreuses doit être un entier valide.");
            }
        }

        System.out.println("Nombre de chocolatiers : " + nbChocolatiers);
        System.out.println("Nombre de mouleuses : " + nbMouleuses);
        System.out.println("Nombre de tempéreuses : " + nbTempereuses);

        // Création de la chocolaterie et démarrage des chocolatiers
        Chocolaterie chocolaterie = new Chocolaterie(nbMouleuses, nbTempereuses);
        for (int i = 0; i < nbChocolatiers; i++) {
            new Chocolatier(i, chocolaterie).start();
        }
    }
}

