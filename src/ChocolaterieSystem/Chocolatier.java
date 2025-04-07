package ChocolaterieSystem;

import ChocolaterieSystem.Chocolaterie;

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
            chocolaterie.requiereTempereuse(id);
            chocolaterie.tempereChocolat(id, provenance);
            chocolaterie.libereTempereuse(id);

            chocolaterie.requiereMouleuse(id);
            chocolaterie.mouleChocolat(id, provenance);
            chocolaterie.refroiditChocolat(id);
            chocolaterie.donneChocolat(id);
            chocolaterie.libereMouleuse(id);
        } catch (InterruptedException e) {
            System.err.println("Chocolatier " + id + " interrompu.");
        }
    }
}
