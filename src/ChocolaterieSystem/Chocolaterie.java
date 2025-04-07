package ChocolaterieSystem;

import java.util.concurrent.Semaphore;

public class Chocolaterie {
    private final Semaphore mouleuses;
    private final Semaphore tempereuses;


    public Chocolaterie() {
        this.mouleuses = new Semaphore(2); // Seulement 2 mouleuses disponibles
        this.tempereuses = new Semaphore(3);
    }

    public void requiereMouleuse(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " attend une mouleuse...");
        mouleuses.acquire();
        System.out.println("Chocolatier " + id + " a obtenu une mouleuse.");
    }

    public void libereMouleuse(int id) {
        mouleuses.release();
        System.out.println("Chocolatier " + id + " a libéré une mouleuse.");
    }

    public void requiereTempereuse(int id) throws InterruptedException{
        System.out.println("Chocolatier " + id + " attend une tempereuse...");
        tempereuses.acquire();
        System.out.println("Chocolatier " + id + " a obtenu une tempereuse.");
    }
    public void libereTempereuse(int id) {
        tempereuses.release();
        System.out.println("Chocolatier " + id + " a libéré une tempereuse.");
    }

    public void tempereChocolat(int id, String provenance) throws InterruptedException {
        System.out.println("Chocolatier " + id + " tempère le chocolat " + provenance + "...");
        Thread.sleep(500); // simulation du temps
    }

    public void mouleChocolat(int id, String provenance) throws InterruptedException {
        System.out.println("Chocolatier " + id + " moule le chocolat " + provenance + "...");
        Thread.sleep(500);
    }

    public void refroiditChocolat(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " refroidit le chocolat...");
        Thread.sleep(500);
    }

    public void donneChocolat(int id) throws InterruptedException {
        System.out.println("Chocolatier " + id + " donne le chocolat.");
        Thread.sleep(300);
    }



    // Point d'entrée pour tester
    public static void main(String[] args) {
        int nbChocolatiers = 5;
        Chocolaterie chocolaterie = new Chocolaterie();

        for (int i = 0; i < nbChocolatiers; i++) {
            new Chocolatier(i, chocolaterie).start();
        }
    }
}
