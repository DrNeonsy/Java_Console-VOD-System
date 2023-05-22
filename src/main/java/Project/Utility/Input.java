package Project.Utility;

import java.util.Scanner;
import java.util.function.Function;

public class Input {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Methods─────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    public static boolean isAlpha(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public static boolean isAlphaWithSpaces(String input) {
        return input.matches("[a-zA-Z ]+");
    }

    public static boolean isNumeric(String input) {
        return input.matches("[0-9]+");
    }

    public static boolean isAlphaNumeric(String input) {
        return input.matches("[a-zA-Z0-9]+");
    }

    public static boolean isAlphaNumericWithSpaces(String input) {
        return input.matches("[a-zA-Z0-9 ]+");
    }

    public static boolean isAlphaNumericWithSpacesAndSpecialCharacters(String input) {
        return input.matches("[a-zA-Z0-9 !@#$%^&*()_+=-]+");
    }

    public static boolean isPhoneNumber(String input) {
        return input.matches("[0-9]");
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

    public static String getValidInput(String instruction, String what, Function<String,Boolean> validationFunctions) {
        while(true){
            Scanner scanner = new Scanner(System.in);

            System.out.printf("%n%s%n", instruction);
            System.out.printf("Enter %s: ", what);
            String input =  scanner.nextLine();

            if (validationFunctions.apply(input)) {
                Utility.clear();
                return input;
            }
            System.out.println("Incorrect Input! Please Try Again!");
            System.out.printf("%n%s%n", "=".repeat(50));
        }
    }
}
