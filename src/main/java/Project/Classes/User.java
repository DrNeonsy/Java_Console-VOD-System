package Project.Classes;

import Project.Interfaces.IUsers;

public abstract class User implements IUsers {
    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────FIELDS──────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String zip;
    private String country;


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
