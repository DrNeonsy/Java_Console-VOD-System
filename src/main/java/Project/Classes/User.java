package Project.Classes;

import Project.Data.Enums.Countries;
import Project.Interfaces.IUsers;

public abstract class User implements IUsers {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────FIELDS──────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    private String name = null;
    private String lastname = null;
    private String email = null;
    private String password = null;
    private String phone = null;
    private String address = null;
    private String city = null;
    private String zip = null;
    private Countries country = null;


    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Constructor──────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Methods─────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    @Override
    public void register() {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void viewUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void viewMovie() {

    }

    @Override
    public void viewTransactions() {

    }

    @Override
    public void viewInventory() {

    }

    @Override
    public void deleteUser() {

    }
}
