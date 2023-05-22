package Project.Classes;

import Project.Classes.Subtypes.Movie;
import Project.Utility.Input;

import java.util.ArrayList;

public class Application {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────FIELDS──────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    public static final ArrayList<Movie> MOVIES = new ArrayList<>();
    public static final ArrayList<User> USERS = new ArrayList<>();

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Methods─────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    public static void initialization() {
        if (!adminExists(null)) {
            // Create Admin

        }
    }

    public void mainMenu() {
        System.out.println("Welcome to the Movie Store!" + System.lineSeparator());

        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

    }

    /// <summary>
    /// Checks If An Admin / Seller Already Exists
    /// </summary>
    /// <param name="cUser">The User To Exclude</param>
    /// <returns>True If An Admin Exist Otherwise False</returns>
    public static boolean adminExists(User cUser) {
        if (cUser != null) {
            // Loop through USERS and check if there is an admin
            for (User user : USERS) {
                if (user instanceof Seller && user != cUser) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void userRegistration() {
        String name = Input.getValidInput(
                """
                        Only Use Alpha Values
                        No Whitespace Allowed
                        Min 2 Max 18
                        """,
                "First Name",
                uInput -> (Input.isAlpha(uInput)
                        && Input.isInputLengthValid(uInput, 2, 18))
        );

        String lastname = Input.getValidInput(
                """
                        Only Use Alpha Values
                        No Whitespace Allowed
                        Length: Min 2 Max 18
                        """,
                "Last Name",
                uInput -> (Input.isAlpha(uInput)
                        && Input.isInputLengthValid(uInput, 2, 18))
        );

        String email = Input.getValidInput(
                """
                        Only Use Alpha Numeric Values And "- . _"
                        Basic E-Mail Format Rules Apply
                        Length: Max 30
                        """,
                "E-Mail",
                uInput -> (Input.isEmailInput(uInput)
                        && Input.isInputLengthValid(uInput, 0, 30))
        );

        String password = Input.getValidInput(
                """
                        Use Min 1 Of Each Upper/Lower/Numeric/
                        Length: Min 8 Max 42
                        """,
                "Password",
                uInput -> (Input.isPasswordInput(uInput)
                        && Input.isInputLengthValid(uInput, 8, 42))
        );

        String phone = Input.getValidInput(
                """
                        Only Use Numeric Values Without Country Code
                        Length: Min 12 Max 13
                        """,
                "Phone Number",
                uInput -> (Input.isPhoneNumber(uInput)
                && Input.isInputLengthValid(uInput,12,13))
        );

        String street = Input.getValidInput(
                """
                        Only AlphaNumeric Values With Whitespaces
                        Length: Min 2 Max 21
                        """,
                "Street Name",
                uInput -> (Input.isAlphaNumericWithSpaces(uInput)
                && Input.isInputLengthValid(uInput,2,21))
        );

        String sNr = Input.getValidInput(
                """
                        Only AlphaNumeric Values
                        Length: Min 1 Max 4
                        """,
                "Street Number",
                uInput -> (Input.isAlphaNumeric(uInput)
                && Input.isInputLengthValid(uInput,1,4))
        );

        String city = Input.getValidInput(
                """
                        Only Alpha Values
                        Length: Min 1 Max 36
                        """,
                "City Name",
                uInput -> (Input.isAlpha(uInput)
                && Input.isInputLengthValid(uInput,1,36))
        );

        String zip = Input.getValidInput(
                """
                        Only Numeric Values
                        Length: 5
                        """,
                "ZIP Code",
                uInput -> (Input.isNumeric(uInput)
                && Input.isInputLengthValid(uInput,5,5))
        );

        String country = Input.getValidInput(
                """
                        Only Use Alpha Values With Whitespace                        
                        """,
                "Country Name",
                uInput -> (Input.isAlphaWithSpaces(uInput))
        );
    }
}
