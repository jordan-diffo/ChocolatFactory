package ChocolaterieSystem;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Chocolaterie {
    private final List<Mouleuse> mouleuses;
    private final List<Tempereuse> tempereuses;

    // Constructeur avec un nombre configurable de mouleuses et tempéreuses
    public Chocolaterie(int nbMouleuses, int nbTempereuses) {
        this.mouleuses = new ArrayList<>();
        this.tempereuses = new ArrayList<>();

        // Création des mouleuses avec des noms distincts
        for (int i = 0; i < nbMouleuses; i++) {
            mouleuses.add(new Mouleuse("M" + (i + 1)));
        }

        // Création des tempéreuses avec des noms distincts
        for (int i = 0; i < nbTempereuses; i++) {
            tempereuses.add(new Tempereuse("T" + (i + 1)));
        }
    }

    // Méthodes pour gérer les mouleuses
    /*public void requiereMouleuse(int id) throws InterruptedException {
        for (Mouleuse mouleuse : mouleuses) {
            if (mouleuse.getSemaphore().tryAcquire()) {
                System.out.println("Chocolatier " + id + " a obtenu la mouleuse " + mouleuse.getMouleuseNom() + " !");
                return;
            }
        }
        System.out.println("Chocolatier " + id + " attend une mouleuse.");
        for (Mouleuse mouleuse : mouleuses) {
            mouleuse.getSemaphore().acquire();
            System.out.println("Chocolatier " + id + " a obtenu la mouleuse " + mouleuse.getMouleuseNom() + " !");
            return;
        }
    }*/

    public boolean requiereMouleuse(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " tente d'obtenir une mouleuse...");

        // Simulation d'une rupture (20% de chances)
        if (Math.random() < 0.2) {
            System.out.println("Rupture simulée : Chocolatier " + id + " ne peut pas mouler pour le moment.");
            Thread.sleep(1000); // Attente avant de réessayer
            return requiereMouleuse(id); // Réessayer récursivement
        }

        // Essaye d'acquérir une mouleuse immédiatement
        for (Mouleuse mouleuse : mouleuses) {
            if (mouleuse.getSemaphore().tryAcquire()) {
                System.out.println("Chocolatier " + id + " a obtenu la mouleuse " + mouleuse.getMouleuseNom());
                return true;
            }
        }

        // Si aucune n'est libre immédiatement, on attend
        System.out.println("Toutes les mouleuses sont occupées. Chocolatier " + id + " attend...");

        for (Mouleuse mouleuse : mouleuses) {
            mouleuse.getSemaphore().acquire();
            System.out.println("Chocolatier " + id + " a obtenu la mouleuse " + mouleuse.getMouleuseNom());
            return true;
        }

        System.err.println("Erreur inattendue : aucune mouleuse acquise.");
        return false;
    }


    public void libereMouleuse(int id) {
        for (Mouleuse mouleuse : mouleuses) {
            if (mouleuse.getSemaphore().availablePermits() == 0) {
                mouleuse.getSemaphore().release();
                System.out.println("Chocolatier " + id + " a libéré la mouleuse " + mouleuse.getMouleuseNom() + " !");
                return;
            }
        }
    }

    // Méthodes pour gérer les tempéreuses
    /*public void requiereTempereuse(int id) throws InterruptedException {
        for (Tempereuse tempereuse : tempereuses) {
            if (tempereuse.getSemaphore().tryAcquire()) {
                System.out.println("Chocolatier " + id + " a obtenu la tempéreuse " + tempereuse.getTempereuseNom() + " !");
                return;
            }
        }
        System.out.println("Chocolatier " + id + " attend une tempéreuse.");
        for (Tempereuse tempereuse : tempereuses) {
            tempereuse.getSemaphore().acquire();
            System.out.println("Chocolatier " + id + " a obtenu la tempéreuse " + tempereuse.getTempereuseNom() + " !");
            return;
        }
    }*/

    public boolean requiereTempereuse(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " attend une tempéreuse...");

        // Simule une rupture (20% de chance)
        if (Math.random() < 0.20) {
            System.out.println("Rupture simulée : Chocolatier " + id + " ne peut pas tempérer pour le moment.");
            Thread.sleep(1000);
            return requiereTempereuse(id); // Retente d'acquérir la tempéreuse après 1 seconde
        }

        // Essaye de prendre une tempéreuse sans attendre (non bloquant)
        for (Tempereuse tempereuse : tempereuses) {
            if (tempereuse.getSemaphore().tryAcquire()) {
                System.out.println("Chocolatier " + id + " a obtenu la tempéreuse " + tempereuse.getTempereuseNom());
                return true;
            }
        }

        // Si toutes sont occupées, on attend sur la première disponible
        System.out.println("Toutes les tempéreuses sont occupées. Chocolatier " + id + " attend...");
        for (Tempereuse tempereuse : tempereuses) {
            if (tempereuse.getSemaphore().tryAcquire(2, TimeUnit.SECONDS)) {
                System.out.println("Chocolatier " + id + " a finalement obtenu la tempéreuse " + tempereuse.getTempereuseNom());
                return true;
            }
        }

        System.err.println("Erreur inattendue : aucune tempéreuse acquise.");
        return false;
    }

    public void libereTempereuse(int id) {
        for (Tempereuse tempereuse : tempereuses) {
            if (tempereuse.getSemaphore().availablePermits() == 0) {
                tempereuse.getSemaphore().release();
                System.out.println("Chocolatier " + id + " a libéré la tempéreuse " + tempereuse.getTempereuseNom() + " !");
                return;
            }
        }
    }

    public void tempereChocolat(int id, String provenance) throws InterruptedException {
        System.out.println("Chocolatier " + id + " tempère le chocolat " + provenance + ".");
        Thread.sleep(500); // simulation du temps
    }

    public void donneChocolat(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " donne le chocolat.");
        Thread.sleep(300);
    }

    public void remplit(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " remplit le moule.");
        Thread.sleep(800);
        System.out.println("Moule rempli.");
    }

    public void garnit(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " garnit le moule.");
        Thread.sleep(600);
        System.out.println("Moule garni.");
    }

    public void ferme(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " ferme le moule.");
        Thread.sleep(400);
        System.out.println("Moule fermé.");
    }
}

