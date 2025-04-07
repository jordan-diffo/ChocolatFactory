import ChocolaterieSystem.Chocolaterie;
import ChocolaterieSystem.Chocolatier;

public class Main {
    public static void main(String[] args) {
        int nbChocolatiers = 5; // Valeur par défaut

        // Vérification de l'argument passé en ligne de commande
        if (args.length > 0) {
            try {
                nbChocolatiers = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Le nombre de chocolatiers doit être un entier valide.");
            }
        }

        System.out.println("Nombre de chocolatiers : " + nbChocolatiers);

        // Création de la chocolaterie et démarrage des chocolatiers
        Chocolaterie chocolaterie = new Chocolaterie();
        for (int i = 0; i < nbChocolatiers; i++) {
            new Chocolatier(i, chocolaterie).start();
        }
    }
}
