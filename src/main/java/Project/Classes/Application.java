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
        if (adminCounter() <= 0) {
            USERS.add(new Seller());
        }
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("Welcome to the Movie Store!" + System.lineSeparator());

            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            switch (Integer.parseInt(Input.getValidInput("", "Choose an Option", uInput -> (Input.isNumeric(uInput, 1, 1))))) {
                case 1 -> login();
                case 2 -> USERS.add(new Buyer());
                case 3 -> System.exit(0);
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

        System.out.println("Login:");
    //Ask for correct password and email
        for (User u: USERS) {
           if(Input.getValidInput("","E-mail",uInput -> Input.isEmailInput(uInput,30)).equals(u.getEmail()) && Input.getValidInput("","Password",uInput -> Input.isPasswordInput(uInput)).equals(u.getPassword())){
               System.out.println("Login erfolgreich :)");
           }
        }
        System.out.println("Try again :(");
    }

}
