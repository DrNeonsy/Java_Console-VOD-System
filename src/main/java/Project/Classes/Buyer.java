package Project.Classes;

import Project.Classes.Subtypes.Transaction;
import Project.Data.Enums.Countries;
import Project.Interfaces.IBuyers;

import java.util.ArrayList;

public class Buyer extends User implements IBuyers {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────FIELDS──────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    private int buyerID;
    private String creditCardNumber = null;
    private String creditCardExpiration = null;
    private String creditCardCVV = null;
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
