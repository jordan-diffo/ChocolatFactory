import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tempereuse {
    private final Lock lock = new ReentrantLock(); // pour la synchronisation

    public void tempereChocolat() {
        try {
            lock.lock();
            System.out.println("Températion du chocolat...");
            // Attendre un moment pour simuler le temps de travail
            Thread.sleep(1000);
            System.out.println("Chocolat tempéré.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void donneChocolat() {
        try {
            lock.lock();
            System.out.println("Donner le chocolat...");
            Thread.sleep(500);
            System.out.println("Chocolat donné.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
