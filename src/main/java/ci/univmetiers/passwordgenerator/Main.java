package ci.univmetiers.passwordgenerator;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        // Vérification du nombre d'arguments
        if (args.length < 5) {
            System.out.println("Usage : java Main <length> <lower> <upper> <digits> <symbols> [count]");
            System.out.println("Exemple : java Main 12 true true false false 5");
            return;
        }

        // 1. longueur
        int length = Integer.parseInt(args[0]);

        // 2. types de caractères
        boolean lower = Boolean.parseBoolean(args[1]);
        boolean upper = Boolean.parseBoolean(args[2]);
        boolean digits = Boolean.parseBoolean(args[3]);
        boolean symbols = Boolean.parseBoolean(args[4]);

        // 3. nombre de mots de passe (mode rafale)
        int count = 1;
        if (args.length >= 6) {
            count = Integer.parseInt(args[5]);
        }

        // 4. générateur
        PasswordGenerator generator = new PasswordGenerator();

        // 5. génération en boucle
        for (int i = 1; i <= count; i++) {

            try {

                String password = generator.generate(length, lower, upper, digits, symbols);

                ProcessBuilder pb = new ProcessBuilder(
                        "docker", "run", "--rm",
                        "password-analyzer",
                        password
                );

                Process process = pb.start();

                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(process.getInputStream()));

                String strength = reader.readLine();

                System.out.println(i + ". " + password + " → " + strength);

            } catch (Exception e) {
                System.out.println("Erreur Docker : " + e.getMessage());
            }
        }
}
}