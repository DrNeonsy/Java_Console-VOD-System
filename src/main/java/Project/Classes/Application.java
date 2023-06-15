package Project.Classes;

import Project.Classes.Subtypes.Movie;
import Project.Data.JSON.JSONHandler;
import Project.Utility.Input;

import java.io.IOException;
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
    public static void initialization() throws IOException {
        if (adminCounter() <= -1) {
            USERS.add(new Seller(true));
        }
        mainMenu();
    }

    private static void mainMenu() throws IOException {
        while (true) {
            System.out.println("Welcome to the Movie Store!" + System.lineSeparator());

            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            switch (Integer.parseInt(Input.getValidInput("", "Choose an Option", uInput -> (Input.isNumeric(uInput, 1, 1))))) {
                case 1 -> login();
                case 2 -> USERS.add(new Buyer(true));
                case 3 -> {
                    JSONHandler.saveUser();
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Checks how many Admin/Seller already exist.
     *
     * @return Number of admins.
     */

    public static int adminCounter() {
        int a = 0;
        for (User user : USERS) {
            if (user instanceof Seller) {
                a++;
            }
        }
        return a;
    }


    private static void login() {

        System.out.println("Login");

        String emailInput = Input.getValidInput("", "E-mail", uInput -> Input.isEmailInput(uInput, 30));
        String pwInput = Input.getValidInput("", "Password", Input::isPasswordInput);

        for (User u : USERS) {
            if (emailInput.equals(u.getEmail()) && pwInput.equals(u.getPassword())) {
                u.userMenu();
                return;
            }
        }
        System.out.println("You've faile:D jeyson! :)");
    }

}
