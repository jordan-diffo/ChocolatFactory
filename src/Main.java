import ChocolaterieSystem.Chocolaterie;
import ChocolaterieSystem.Chocolatier;

public class Main {
    public static void main(String[] args) {
        Chocolaterie chocolaterie = new Chocolaterie(); // Une seule instance partagée

        for (int i = 0; i < 5; i++) {
            new Chocolatier(i, chocolaterie).start();
        }
    }
}
