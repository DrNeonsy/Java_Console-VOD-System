package Project.Data.JSON;

import Project.Classes.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class JSONHandler {
    private static final String JSONFile = System.getProperty("user.dir") + "/src/main/java/Project/Data/JSON/Template.json";

    public static void saveUser() throws IOException {
        UserDatabase udb = new UserDatabase(Application.USERS);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        FileWriter fw = new FileWriter(JSONFile);

        gson.toJson(udb, fw);

        fw.close();
    }
}
