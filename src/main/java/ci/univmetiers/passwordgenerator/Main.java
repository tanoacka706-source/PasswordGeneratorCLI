package ci.univmetiers.passwordgenerator;

public class Main {

    public static void main(String[] args) {

        // Vérification du nombre d'arguments
        if (args.length < 5) {
            System.out.println("Usage : java Main <length> <lower> <upper> <digits> <symbols>");
            System.out.println("Exemple : java Main 12 true true false false");
            return;
        }

        // 1. longueur
        int length = Integer.parseInt(args[0]);

        // 2. types de caractères
        boolean lower = Boolean.parseBoolean(args[1]);
        boolean upper = Boolean.parseBoolean(args[2]);
        boolean digits = Boolean.parseBoolean(args[3]);
        boolean symbols = Boolean.parseBoolean(args[4]);

        // 3. génération
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generate(length, lower, upper, digits, symbols);

        // 4. affichage
        System.out.println("Mot de passe généré : " + password);
    }
}