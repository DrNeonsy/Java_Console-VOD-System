package Project.Classes;

import Project.Classes.Subtypes.Movie;
import Project.Data.Enums.Countries;
import Project.Utility.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        switch (Integer) {
            case 1 -> login();
            case 2 -> {
                USERS.add(new Buyer());
                userRegistration(USERS.get(USERS.size() - 1));
            }
            case 3 -> System.exit(0);
        }
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

    private static void userRegistration(User U) {

    }

    private static void login() {

    }

    public static String setFirstName() {
        return Input.getValidInput(
                """
                        Only Use Alpha Values
                        No Whitespace Allowed
                        Min 2 Max 18
                        """,
                "First Name",
                uInput -> (Input.isAlpha(uInput, 2, 18))
        );
    }

    public static String setLastName() {
        return Input.getValidInput(
                """
                        Only Use Alpha Values
                        No Whitespace Allowed
                        Length: Min 2 Max 18
                        """,
                "Last Name",
                uInput -> (Input.isAlpha(uInput, 2, 18))
        );
    }

    public static String setEmail() {
        return Input.getValidInput(
                """
                        Only Use Alpha Numeric Values And "- . _"
                        Basic E-Mail Format Rules Apply
                        Length: Max 30
                        """,
                "E-Mail",
                uInput -> (Input.isEmailInput(uInput, 30))
        );
    }

    public static String setPassword() {
        return Input.getValidInput(
                """
                        Use Min 1 Of Each Upper/Lower/Numeric/Special
                        Length: Min 8
                        """,
                "Password",
                Input::isPasswordInput
        );
    }

    public static String setSTrEetName() {
        return Input.getValidInput(
                """
                        Only AlphaNumeric Values With Whitespaces
                        Length: Min 2 Max 21
                        """,
                "Street Name",
                uInput -> (Input.isAlphaNumericWithSpaces(uInput, 2, 21))
        );
    }

    public static String setStreetNr() {
        return Input.getValidInput(
                """
                        Only AlphaNumeric Values
                        Length: Min 1 Max 4
                        """,
                "Street Number",
                uInput -> (Input.isAlphaNumeric(uInput, 1, 4))
        );
    }

    public static String setCity() {
        return Input.getValidInput(
                """
                        Only Alpha Values
                        Length: Min 1 Max 36
                        """,
                "City Name",
                uInput -> (Input.isAlpha(uInput, 1, 36))
        );
    }

    public static String setZipCode() {
        return Input.getValidInput(
                """
                        Only Numeric Values
                        Length: 5
                        """,
                "ZIP Code",
                uInput -> (Input.isNumeric(uInput, 5, 5))
        );
    }

    public static Countries setCountry() {
        while (true) {
            String country = Input.getValidInput(
                    """
                            Only Use Alpha Values With Whitespace
                            Min 2 Max 4
                            """,
                    "Country Name",
                    input -> Input.isAlphaWithSpaces(input, 2, 4)
            );


            final HashMap<Character, Countries> RESULTS = new HashMap<>();

            int rCount = 0;

            for (Countries co : Countries.values()) {
                if (co.toString().substring(0, country.length()).equalsIgnoreCase(country)) {
                    RESULTS.put((char) rCount++, co);
                }
            }

            if (!RESULTS.isEmpty()) {
                for (Map.Entry<Character, Countries> entry : RESULTS.entrySet()) {
                    int key = entry.getKey();
                    Countries value = entry.getValue();
                    System.out.printf("%-36s%5s%5s%n", value, '|', key);
                }

                char c = (char) (Input.getValidInput(
                        """
                                Choose a country or press enter search for another country
                                """,
                        "Confirm Country",
                        input -> Input.isNumeric(input, 0, 1)
                ).charAt(0) - '0');

                if (RESULTS.containsKey(c)) {
                    return RESULTS.get(c);
                }
            }
        }
    }

    public static String setPhoneNr() {
        return Input.getValidInput(
                """
                        Only Use Numeric Values Without Country Code
                        Length: Min 12 Max 13
                        """,
                "Phone Number",
                uInput -> (Input.isPhoneNumber(uInput, 12, 13))
        );
    }
}
