package ChocolaterieSystem;

import java.util.concurrent.Semaphore;

class Mouleuse {
    private final Semaphore semaphore;
    private final String nom;

    public Mouleuse(String nom) {
        this.nom = nom;
        this.semaphore = new Semaphore(1); // Une seule chocolatière peut utiliser la mouleuse à la fois
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public String getNom() {
        return nom;
    }
}
