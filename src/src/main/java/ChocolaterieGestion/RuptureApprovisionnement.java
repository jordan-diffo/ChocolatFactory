package ChocolaterieGestion;

import java.util.concurrent.Semaphore;

public class RuptureApprovisionnement {
    private Semaphore chocolateDisponible;
    private Semaphore mouleDisponible;

    public RuptureApprovisionnement(int chocolatMax, int mouleMax) {
        this.chocolateDisponible = new Semaphore(chocolatMax, true);
        this.mouleDisponible = new Semaphore(mouleMax, true);
    }

    // Simulation d'une rupture d'approvisionnement en chocolat
    public void attendreChocolat() throws InterruptedException {
        chocolateDisponible.acquire();
    }

    // Simulation d'une rupture d'approvisionnement en moules
    public void attendreMoule() throws InterruptedException {
        mouleDisponible.acquire();
    }

    // Libération du chocolat lorsqu'il est disponible à nouveau
    public void libereChocolat() {
        chocolateDisponible.release();
    }

    // Libération des moules lorsqu'ils sont disponibles à nouveau
    public void libereMoule() {
        mouleDisponible.release();
    }
}

