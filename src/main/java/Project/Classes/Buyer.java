package Project.Classes;

import Project.Classes.Subtypes.Transaction;
import Project.Interfaces.IBuyers;

import java.util.ArrayList;

public class Buyer extends User implements IBuyers {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────FIELDS──────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    private int buyerID;
    private String creditCardNumber;
    private String creditCardExpiration;
    private String creditCardCVV;
    private final ArrayList<Transaction> TRANSACTIONS = new ArrayList<>();

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Constructor──────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Methods─────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────


    @Override
    public void addToCart() {

    }

    @Override
    public void removeFromCart() {

    }

    @Override
    public void viewCart() {

    }

    @Override
    public void checkout() {

    }
}
