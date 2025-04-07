package ChocolaterieSystem;

import java.util.concurrent.Semaphore;

class Tempereuse {
    private final Semaphore semaphore;
    private final String nom;

    public Tempereuse(String nom) {
        this.nom = nom;
        this.semaphore = new Semaphore(1); // Une seule chocolatière peut utiliser la tempéreuse à la fois
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public String getNom() {
        return nom;
    }
}
