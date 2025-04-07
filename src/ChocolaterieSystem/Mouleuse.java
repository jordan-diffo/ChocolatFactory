package ChocolaterieSystem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mouleuse {
    private final Lock lock = new ReentrantLock(); // pour la synchronisation

    public void remplit() {
        try {
            lock.lock();
            System.out.println("Remplissage du moule...");
            Thread.sleep(800);
            System.out.println("Moule rempli.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void garnit() {
        try {
            lock.lock();
            System.out.println("Garniture du moule...");
            Thread.sleep(600);
            System.out.println("Moule garni.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void ferme() {
        try {
            lock.lock();
            System.out.println("Fermeture du moule...");
            Thread.sleep(400);
            System.out.println("Moule fermé.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
