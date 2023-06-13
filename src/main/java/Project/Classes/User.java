package Project.Classes;

import Project.Data.CountryCodes;
import Project.Data.Enums.Countries;
import Project.Interfaces.IUsers;
import Project.Utility.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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
    private Countries country;
    protected static final ArrayList<String> userOptions = new ArrayList<>() {{
        add(String.format("%-18s%5s%3d", "Profile", '|', 1));
        add(String.format("%-18s%5s%3d", "Catalog", '|', 2));
        add(String.format("%-18s%5s%3d", "Inventory", '|', 3));
        add(String.format("%-18s%5s%3d", "Transactions", '|', 4));
    }};

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Constructor──────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────

    public User() {
        this.name = setFirstName();
        this.lastname = setLastName();
        this.email = setEmail();
        this.password = setPassword();
        this.phone = setPhoneNr();
        this.address = setStreeeeetName() + " " + setStreetNr();
        this.city = setCity();
        this.zip = setZipCode();
        this.country = setCountry();

        this.phone = '+' + CountryCodes.COUNTRY_CODES.get(country) + " " + phone;
    }

    // ───────────────────────────────────────────────────────────────────────────────
    // ───────────────────────────────Methods─────────────────────────────────────────
    // ───────────────────────────────────────────────────────────────────────────────


    @Override
    public void userMenu() {
        while (true) {
            //region output
            System.out.println();

            if (this instanceof Buyer) {
                for (String s : Buyer.buyerOptions) {
                    System.out.println(s);
                }
            }
            if (this instanceof Seller) {
                for (String s : Seller.sellerOptions) {
                    System.out.println(s);
                }
            }
            //endregion

            //region option selection
            int option = Integer.parseInt(Input.getValidInput("", "Choose an Option", uInput -> (Input.isNumeric(uInput, 1, 1))));
            switch (option) {
                case 1 -> viewUser();
                case 2 -> viewMovieCatalog();
                case 3 -> viewInventory();
                case 4 -> viewTransactions();
            }
            if (this instanceof Buyer b) {
                switch (option) {
                    case 5 -> b.viewCart();
                    case 6 -> b.checkout();
                    case 7 -> {
                        return;
                    }
                }
            }
            if (this instanceof Seller) {
                if (option == 5) {
                    return;
                }
            }
            //endregion
        }
    }

    @Override
    public void viewUser() {
        String s = '{' +
                "name='" + name +
                ", lastname='" + lastname +
                ", email='" + email +
                ", password='" + password +
                ", phone='" + phone +
                ", address='" + address +
                ", city='" + city +
                ", zip='" + zip +
                ", country=" + country +
                '}';
        System.out.println(s);
    }

    @Override
    public void updateUser() { // Profile

    }

    @Override
    public void viewMovieCatalog() {

    }

    @Override
    public void viewTransactions() {

    }

    @Override
    public void viewInventory() {

    }

    @Override
    public void deleteUser() { // Profile

    }

    protected static String setFirstName() {
        return Input.getValidInput(
                """
                        Only Use Alpha Values
                        No Whitespace Allowed
                        Min 2 Max 18
                        """,
                "First Name",
                uInput -> (Input.isAlpha(uInput, 2, 18))
        );
    }

    protected static String setLastName() {
        return Input.getValidInput(
                """
                        Only Use Alpha Values
                        No Whitespace Allowed
                        Length: Min 2 Max 18
                        """,
                "Last Name",
                uInput -> (Input.isAlpha(uInput, 2, 18))
        );
    }

    protected static String setEmail() {
        return Input.getValidInput(
                """
                        Only Use Alpha Numeric Values And "- . _"
                        Basic E-Mail Format Rules Apply
                        Length: Max 30
                        """,
                "E-Mail",
                uInput -> (Input.isEmailInput(uInput, 30))
        );
    }

    protected static String setPassword() {
        return Input.getValidInput(
                """
                        Use Min 1 Of Each Upper/Lower/Numeric/Special
                        Length: Min 8
                        """,
                "Password",
                Input::isPasswordInput
        );
    }

    protected static String setStreeeeetName() {
        return Input.getValidInput(
                """
                        Only AlphaNumeric Values With Whitespaces
                        Length: Min 3 Max 21
                        """,
                "Street Name",
                uInput -> (Input.isAlphaWithSpaces(uInput, 3, 21))
        );
    }

    protected static String setStreetNr() {
        return Input.getValidInput(
                """
                        Only AlphaNumeric Values
                        Length: Min 1 Max 4
                        """,
                "Street Number",
                uInput -> (Input.isAlphaNumeric(uInput, 1, 4))
        );
    }

    protected static String setCity() {
        return Input.getValidInput(
                """
                        Only Alpha Values
                        Length: Min 4 Max 36
                        """,
                "City Name",
                uInput -> (Input.isAlpha(uInput, 4, 36))
        );
    }

    protected static String setZipCode() {
        return Input.getValidInput(
                """
                        Only Numeric Values
                        Length: 5
                        """,
                "ZIP Code",
                uInput -> (Input.isNumeric(uInput, 5, 5))
        );
    }

    protected static Countries setCountry() {
        while (true) {
            String country = Input.getValidInput(
                    """
                            Only Use Alpha Values With Whitespace
                            Min 2 Max 4
                            """,
                    "Country Name",
                    input -> Input.isAlphaWithSpaces(input, 2, 4)
            );


            final HashMap<Character, Countries> RESULTS = new HashMap<>();

            int rCount = 0;

            for (Countries co : Countries.values()) {
                if (co.toString().substring(0, country.length()).equalsIgnoreCase(country)) {
                    RESULTS.put((char) rCount++, co);
                }
            }

            if (!RESULTS.isEmpty()) {
                for (Map.Entry<Character, Countries> entry : RESULTS.entrySet()) {
                    int key = entry.getKey();
                    Countries value = entry.getValue();
                    System.out.printf("%-36s%5s%5s%n", value, '|', key);
                }

                char c = (char) (Input.getValidInput(
                        """
                                Choose a country or press enter search for another country
                                """,
                        "Confirm Country",
                        input -> Input.isNumeric(input, 0, 1)
                ).charAt(0) - '0');

                if (RESULTS.containsKey(c)) {
                    return RESULTS.get(c);
                }
            }
        }
    }

    protected static String setPhoneNr() {
        return Input.getValidInput(
                """
                        Only Use Numeric Values Without Country Code
                        Length: Min 12 Max 13
                        """,
                "Phone Number",
                uInput -> (Input.isPhoneNumber(uInput, 12, 13))
        );
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
