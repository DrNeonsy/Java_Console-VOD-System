package Project.Classes;

import Project.Interfaces.ISellers;

import java.util.ArrayList;

public class Seller extends User implements ISellers {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────FIELDS──────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    private final int sellerID;
    private static final ArrayList<String> sellerOptions = new ArrayList<>(userOptions) {{
        add(String.format("%-18s%5s%d", "Logout", '|', 5));
    }};

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Constructor──────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    public Seller() {
        this.sellerID = Application.adminCounter();
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
}
