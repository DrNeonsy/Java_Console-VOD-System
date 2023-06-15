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

    public static final ArrayList<String> buyerOptions = new ArrayList<>(userOptions) {{
        add(String.format("%-18s%5s%3d", "View Cart", '|', 5));
        add(String.format("%-18s%5s%3d", "Checkout", '|', 6));
        add(String.format("%-18s%5s%3d", "Logout", '|', 7));
    }};

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Constructor──────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    public Buyer(boolean input) {
        super(input);
        if (input) {
            this.buyerID = Application.USERS.size() - Application.adminCounter() + 1;
        } else {
//            this.creditCardNumber = null;
//            this.creditCardExpiration = null;
//            this.creditCardCVV = null;
//            this.buyerID = null;
        }
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

    @Override
    public String toString() {
        String[] data = new String[]{
                creditCardNumber,
                creditCardExpiration,
                creditCardCVV};

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

        for (String s : data) {
            sb.append(String.format("%-2s%-37s%-2s%n", '|', s, '|'));
        }

        sb.append("BuyerID: ").append(buyerID);

        return sb.toString();
    }
}
