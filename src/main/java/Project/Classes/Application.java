package Project.Classes;

import Project.Classes.Subtypes.Movie;

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
}
