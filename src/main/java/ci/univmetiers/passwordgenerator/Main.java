package ci.univmetiers.passwordgenerator;

public class Main {

    public static void main(String[] args) {

        int length = 20;

        if (args.length > 0) {
            try {
                length = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Erreur : la longueur doit être un nombre entier.");
                return;
            }
        }

        System.out.println("Longueur utilisée : " + length);

        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generate(length);

        System.out.println("Mot de passe généré : " + password);
    }
}