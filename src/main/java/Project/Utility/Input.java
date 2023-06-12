package Project.Utility;

import java.util.Scanner;
import java.util.function.Function;

public class Input {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Methods─────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    public static boolean isAlpha(String input, int min, int max) {
        return input.matches("^[a-zA-Z]+$") && validLength(input, min, max);
    }

    public static boolean isAlphaWithSpaces(String input, int min, int max) {
        return input.matches("^[a-zA-Z][a-zA-Z ]*[a-zA-Z]$") && validLength(input, min, max);
    }

    public static boolean isNumeric(String input, int min, int max) {
        return input.matches("^[0-9\n]+$") && validLength(input, min, max);
    }

    public static boolean isAlphaNumeric(String input, int min, int max) {
        return input.matches("^[a-zA-Z0-9]+$") && validLength(input, min, max);
    }

    public static boolean isAlphaNumericWithSpaces(String input, int min, int max) {
        return input.matches("^[a-zA-Z0-9][a-zA-Z0-9 ]*[a-zA-Z0-9]$") && validLength(input, min, max);
    }

    public static boolean isAlphaNumericWithSpacesAndSpecialCharacters(String input, int min, int max) {
        return input.matches("^[a-zA-Z0-9 !@#$%^&*()_+=-]+$") && validLength(input, min, max);
    }

    public static boolean isPhoneNumber(String input, int min, int max) {
        return input.matches("^[0-9]+$") && validLength(input, min, max);
    }

    public static boolean isEmailInput(String input, int max) {
        return input.matches("^[A-Za-z][A-Za-z0-9_.-]*@[A-Za-z]+[A-Za-z-]*\\.[A-Za-z]{2,3}$") && validLength(input, 0, max);
    }

    public static boolean isPasswordInput(String input) {
        return input.matches("^(?=.{8,}$)(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!?@#$%^&+=])(?=\\S+$).*$");
    }

    private static boolean validLength(String s, int min, int max) {
        return s.length() >= min && s.length() <= max;
    }

    public static String getValidInput(String instruction, String what, Function<String, Boolean> validationFunctions) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.printf("%n%s%n", instruction);
            System.out.printf("Enter %s: ", what);
            String input = scanner.nextLine();

            if (validationFunctions.apply(input)) {
                Utility.clear();
                return input;
            }
            System.out.println("Incorrect Input! Please Try Again!");
            System.out.printf("%n%s%n", "=".repeat(50));
        }
    }
}
