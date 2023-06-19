package Project.Classes;

import Project.Interfaces.ISellers;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.HashMap;

public class Seller extends User implements ISellers {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────FIELDS──────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    private int sellerID;
    public static final ArrayList<String> sellerOptions = new ArrayList<>(userOptions) {{
        add(String.format("%-18s%5s%3d", "Logout", '|', 5));
    }};

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Constructor──────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    public Seller() {
        this.sellerID = Application.adminCounter() + 1;
    }

    public Seller(HashMap<Object, Object> data) {
        super(data);
        this.sellerID = Integer.parseInt((String) data.get("sellerID"));
    }

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Methods─────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    @Override
    public void addMovie() { // Catalog

    }

    @Override
    public void removeMovie() { // Catalog

    }

    @Override
    public void updateMovie() { // Catalog

    }

    public String toString() {

        String sb = "SellerID: " + sellerID + System.lineSeparator() + super.toString();

        return sb;
    }
}
