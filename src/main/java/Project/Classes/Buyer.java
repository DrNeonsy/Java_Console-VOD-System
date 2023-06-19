package Project.Classes;

import Project.Classes.Subtypes.Transaction;
import Project.Interfaces.IBuyers;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Buyer extends User implements IBuyers {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────FIELDS──────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    private int buyerID;
    private String creditCardNumber;
    private String creditCardExpiration;
    private String creditCardCVV;
    private final ArrayList<Transaction> TRANSACTIONS = null;

    public static final ArrayList<String> buyerOptions = new ArrayList<>(userOptions) {{
        add(String.format("%-18s%5s%3d", "View Cart", '|', 5));
        add(String.format("%-18s%5s%3d", "Checkout", '|', 6));
        add(String.format("%-18s%5s%3d", "Logout", '|', 7));
    }};

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Constructor──────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    public Buyer() {
        this.buyerID = Application.USERS.size() - Application.adminCounter() + 1;
    }

    public Buyer(HashMap<Object, Object> data) {
        super(data);
        this.buyerID = Integer.parseInt((String) data.get("buyerID"));
        this.creditCardNumber = (String) data.get("creditCardNumber");
        this.creditCardExpiration = (String) data.get("creditCardExpiration");
        this.creditCardCVV = (String) data.get("creditCardCVV");
//        this.TRANSACTIONS = data.get("TRANSACTIONS");
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
        LinkedHashMap<String, Object> data = new LinkedHashMap<>() {{
            put("creditCardNumber", creditCardNumber);
            put("creditCardExpiration", creditCardExpiration);
            put("creditCardCVV", creditCardCVV);
        }};

        StringBuilder sb = new StringBuilder();

        sb.append("BuyerID: ").append(buyerID).append(System.lineSeparator());
        sb.append(super.toString());

        for (Map.Entry<String, Object> e : data.entrySet()) {
            sb.append(String.format("%-2s%-23s: %-54s%-2s%n", '|', e.getKey(), e.getValue(), '|'));
        }

        return sb.toString();
    }
}
