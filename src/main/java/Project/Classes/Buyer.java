package Project.Classes;

import Project.Classes.Subtypes.Transaction;
import Project.Data.Enums.Countries;
import Project.Interfaces.IBuyers;

import java.util.ArrayList;

public class Buyer extends User implements IBuyers {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────FIELDS──────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    private final int buyerID;
    private String creditCardNumber;
    private String creditCardExpiration;
    private String creditCardCVV;
    private final ArrayList<Transaction> TRANSACTIONS = new ArrayList<>();

    private static final ArrayList<String> buyerOptions = new ArrayList<>(userOptions) {{
        add(String.format("%-18s%5s%d", "View Cart", '|', 5));
        add(String.format("%-18s%5s%d", "Checkout", '|', 6));
        add(String.format("%-18s%5s%d", "Logout", '|', 7));
    }};

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Constructor──────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    public Buyer() {
        this.buyerID = Application.USERS.size() - Application.adminCounter();
    }


    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Methods─────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────


    @Override
    public void addToCart() { // Catalog

    }

    @Override
    public void removeFromCart() { // View Cart

    }

    @Override
    public void viewCart() {

    }

    @Override
    public void checkout() {

    }
}
