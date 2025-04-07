package ChocolaterieSystem;

public class Chocolatier extends Thread {
    private final int chocolatierId;
    private final Chocolaterie chocolaterie;
    private final String provenance;

    public Chocolatier(int id, Chocolaterie chocolaterie) {
        this.chocolatierId = id;
        this.chocolaterie = chocolaterie;
        this.provenance = id % 2 == 0 ? "noir" : "blanc";
    }

    @Override
    public void run() {
        try {
            // Chocolatier attend une tempéreuse
            chocolaterie.requiereTempereuse(chocolatierId);
            chocolaterie.tempereChocolat(chocolatierId, provenance);
            chocolaterie.donneChocolat(chocolatierId);
            chocolaterie.libereTempereuse(chocolatierId); // Libération de la tempéreuse

            // Chocolatier passe à la mouleuse
            chocolaterie.requiereMouleuse(chocolatierId);
            // La mouleuse effectue ses actions
            chocolaterie.remplit(chocolatierId);
            chocolaterie.garnit(chocolatierId);
            chocolaterie.ferme(chocolatierId);
            chocolaterie.libereMouleuse(chocolatierId); // Libération de la mouleuse


        } catch (InterruptedException e) {
            System.err.println("Chocolatier " + chocolatierId + " interrompu.");
        }
    }
}


