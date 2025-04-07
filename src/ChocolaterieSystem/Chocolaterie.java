package ChocolaterieSystem;

import java.util.List;
import java.util.ArrayList;

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
    public void requiereMouleuse(int id) throws InterruptedException {
        for (Mouleuse mouleuse : mouleuses) {
            if (mouleuse.getSemaphore().tryAcquire()) {
                System.out.println("Chocolatier " + id + " a obtenu la mouleuse " + mouleuse.getNom() + " !");
                return;
            }
        }
        System.out.println("Chocolatier " + id + " attend une mouleuse...");
        for (Mouleuse mouleuse : mouleuses) {
            mouleuse.getSemaphore().acquire();
            System.out.println("Chocolatier " + id + " a obtenu la mouleuse " + mouleuse.getNom() + " !");
            return;
        }
    }

    public void libereMouleuse(int id) {
        for (Mouleuse mouleuse : mouleuses) {
            if (mouleuse.getSemaphore().availablePermits() == 0) {
                mouleuse.getSemaphore().release();
                System.out.println("Chocolatier " + id + " a libéré la mouleuse " + mouleuse.getNom() + " !");
                return;
            }
        }
    }

    // Méthodes pour gérer les tempéreuses
    public void requiereTempereuse(int id) throws InterruptedException {
        for (Tempereuse tempereuse : tempereuses) {
            if (tempereuse.getSemaphore().tryAcquire()) {
                System.out.println("Chocolatier " + id + " a obtenu la tempéreuse " + tempereuse.getNom() + " !");
                return;
            }
        }
        System.out.println("Chocolatier " + id + " attend une tempéreuse...");
        for (Tempereuse tempereuse : tempereuses) {
            tempereuse.getSemaphore().acquire();
            System.out.println("Chocolatier " + id + " a obtenu la tempéreuse " + tempereuse.getNom() + " !");
            return;
        }
    }

    public void libereTempereuse(int id) {
        for (Tempereuse tempereuse : tempereuses) {
            if (tempereuse.getSemaphore().availablePermits() == 0) {
                tempereuse.getSemaphore().release();
                System.out.println("Chocolatier " + id + " a libéré la tempéreuse " + tempereuse.getNom() + " !");
                return;
            }
        }
    }

    // Autres méthodes (tempérer, remplir, garnir, fermer, etc.)
    public void tempereChocolat(int id, String provenance) throws InterruptedException {
        System.out.println("Chocolatier " + id + " tempère le chocolat " + provenance + "...");
        Thread.sleep(500); // simulation du temps
    }

    public void donneChocolat(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " donne le chocolat.");
        Thread.sleep(300);
    }

    public void remplit(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " remplit le moule...");
        Thread.sleep(800);
        System.out.println("Moule rempli.");
    }

    public void garnit(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " garnit le moule...");
        Thread.sleep(600);
        System.out.println("Moule garni.");
    }

    public void ferme(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " ferme le moule...");
        Thread.sleep(400);
        System.out.println("Moule fermé.");
    }
}

