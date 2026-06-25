package ci.univmetiers.passwordgenerator;

public class Main {

    public static void main(String[] args) {

        PasswordGenerator generator = new PasswordGenerator();

        String password = generator.generate(12);

        System.out.println("Mot de passe généré : " + password);
    }
}