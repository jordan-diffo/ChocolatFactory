package ChocolaterieSystem;

import java.util.concurrent.Semaphore;

public class ChocolaterieOld {
    private final Semaphore mouleuses;
    private final Semaphore tempereuses;


    public ChocolaterieOld(int nbMouleuses, int nbTempereuses) {
        this.mouleuses = new Semaphore(nbMouleuses); // Nombre configurable de mouleuses
        this.tempereuses = new Semaphore(nbTempereuses); // Nombre configurable de tempéreuses
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
