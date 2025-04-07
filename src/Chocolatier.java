public class Chocolatier implements Runnable {
    private Tempereuse tempereuse;
    private Mouleuse mouleuse;

    public Chocolatier(Tempereuse tempereuse, Mouleuse mouleuse) {
        this.tempereuse = tempereuse;
        this.mouleuse = mouleuse;
    }

    @Override
    public void run() {
        requiereTempereuse();
        tempereChocolat();
        donneChocolat();
        mouleuse.remplit();
        mouleuse.garnit();
        mouleuse.ferme();
    }

    public void requiereTempereuse() {
        System.out.println("Chocolatier demande la tempéreuse.");
    }

    public void tempereChocolat() {
        tempereuse.tempereChocolat();
    }

    public void donneChocolat() {
        tempereuse.donneChocolat();
    }
}

