public class TestFaille {
    public static void main(String[] args) {
        // Mauvaise pratique : mot de passe codé en dur
        String secret = "monMotDePasse123";
        System.out.println("Le mot de passe est: " + secret);
    }
}
