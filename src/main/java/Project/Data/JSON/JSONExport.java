package Project.Data.JSON;

import Project.Classes.Application;
import Project.Classes.Buyer;
import Project.Classes.Seller;
import Project.Classes.Subtypes.Movie;
import Project.Classes.User;

import java.util.ArrayList;

public class JSONExport {
    public final ArrayList<Seller> sellers;
    public final ArrayList<Buyer> buyers;
    public final ArrayList<Movie> movies = new ArrayList<>(Application.MOVIES);

    public JSONExport(ArrayList<User> USERS) {

        buyers = new ArrayList<>();
        sellers = new ArrayList<>();

        for (User u : USERS) {

            if (u instanceof Buyer b) {
                buyers.add(b);
            } else if (u instanceof Seller s) {
                sellers.add(s);
            }
        }
    }
}
