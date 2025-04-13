package ChocolaterieSysteme;

import java.util.concurrent.Semaphore;

class Tempereuse {
    private final Semaphore semaphore;
    private final String tempereuseNom;

    public Tempereuse(String nom) {
        this.tempereuseNom = nom;
        this.semaphore = new Semaphore(1); // Une seule chocolatière peut utiliser la tempéreuse à la fois
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public String getTempereuseNom() {
        return tempereuseNom;
    }
}
