package ci.univmetiers.passwordgenerator;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+";

    private static final SecureRandom RANDOM = new SecureRandom();

    public String evaluateStrength(String password) {

        int length = password.length();

        if (length < 6) return "Très faible";
        if (length < 10) return "Faible";
        if (length < 14) return "Moyen";
        if (length < 18) return "Fort";
        return "Très fort";
    }
    public String generate(int length, boolean lower, boolean upper, boolean digits, boolean symbols) {

        StringBuilder chars = new StringBuilder();

        if (lower) {
            chars.append(LOWER);
        }

        if (upper) {
            chars.append(UPPER);
        }

        if (digits) {
            chars.append(DIGITS);
        }

        if (symbols) {
            chars.append(SYMBOLS);
        }

        // sécurité : si rien n'est sélectionné
        if (chars.length() == 0) {
            throw new IllegalArgumentException("Aucun type de caractère sélectionné !");
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        return password.toString();
    }
}