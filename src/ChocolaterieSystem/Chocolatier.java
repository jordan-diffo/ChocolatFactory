package ChocolaterieSystem;

public class Chocolatier extends Thread {
    private final int id;
    private final Chocolaterie chocolaterie;
    private final String provenance;

    public Chocolatier(int id, Chocolaterie chocolaterie) {
        this.id = id;
        this.chocolaterie = chocolaterie;
        this.provenance = id % 2 == 0 ? "noir" : "blanc";
    }

    @Override
    public void run() {
        try {
            // Chocolatier attend une tempéreuse
            chocolaterie.requiereTempereuse(id);
            chocolaterie.tempereChocolat(id, provenance);
            chocolaterie.donneChocolat(id);
            chocolaterie.libereTempereuse(id); // Libération de la tempéreuse

            // Chocolatier passe à la mouleuse
            chocolaterie.requiereMouleuse(id);
            // La mouleuse effectue ses actions
            chocolaterie.remplit(id);
            chocolaterie.garnit(id);
            chocolaterie.ferme(id);
            chocolaterie.libereMouleuse(id);


        } catch (InterruptedException e) {
            System.err.println("Chocolatier " + id + " interrompu.");
        }
    }
}


