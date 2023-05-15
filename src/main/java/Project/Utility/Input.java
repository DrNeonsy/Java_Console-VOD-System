package Project.Utility;

import java.util.Scanner;

public class Input {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Methods─────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    public static boolean isAlpha(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public static boolean isAlphaWithSpaces(String str) {
        return str.matches("[a-zA-Z ]+");
    }

    public static boolean isNumeric(String str) {
        return str.matches("[0-9]+");
    }

    public static boolean isAlphaNumeric(String str) {
        return str.matches("[a-zA-Z0-9]+");
    }

    public static boolean isAlphaNumericWithSpaces(String str) {
        return str.matches("[a-zA-Z0-9 ]+");
    }

    public static boolean isAlphaNumericWithSpacesAndSpecialCharacters(String str) {
        return str.matches("[a-zA-Z0-9 !@#$%^&*()_+=-]+");
    }

    public static boolean isPhoneNumber(String str) {
        return str.matches("[0-9]");
    }

    public static boolean isEmailInput(String input) {
        return input.matches("^[A-Za-z][A-Za-z0-9_.-]*@[A-Za-z]+\\.[A-Za-z]{2,3}$");
    }

    public static boolean isInputLengthValid(String input, int minLength, int maxLength) {
        return input.length() >= minLength && input.length() <= maxLength;
    }

    public static boolean isPasswordInput(String input) {
        return input.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).*$");
    }

    public static String getInput(String message, String what) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("%n%s%n", message);
        System.out.printf("Enter %s: ", what);
        return scanner.nextLine();
    }
}
