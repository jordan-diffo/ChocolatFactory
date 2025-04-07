public class ExecutorService {
    public static void executer(String nomAction) {
        System.out.println("Action exécutée : " + nomAction);
    }

    public static void executer(String nomAction, int idChocolatier) {
        System.out.println("Action exécutée : " + nomAction + " par le chocolatier " + idChocolatier);
    }

    public static void executer(String nomAction, int idChocolatier, String provenance) {
        System.out.println("Action exécutée : " + nomAction + " par le chocolatier " + idChocolatier + " avec du chocolat de provenance " + provenance);
    }
}
