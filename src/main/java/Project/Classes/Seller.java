package Project.Classes;

import Project.Interfaces.ISellers;

import java.util.ArrayList;

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

    public Seller(boolean input) {
        super(input);
        if (input) {
            this.sellerID = Application.adminCounter() + 1;
        } else {
//            this.sellerID = null;
        }
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

        String sb = super.toString() +
                "SellerID: " + sellerID;

        return sb;
    }
}
