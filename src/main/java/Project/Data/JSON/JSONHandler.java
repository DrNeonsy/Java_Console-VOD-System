package Project.Data.JSON;

import Project.Classes.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONHandler {
    private static final String JSONFile = System.getProperty("user.dir") + "/src/main/java/Project/Data/JSON/Template.json";

    public static void saveData() throws IOException {
        JSONExport udb = new JSONExport(Application.USERS);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        FileWriter fw = new FileWriter(JSONFile);

        gson.toJson(udb, fw);

        fw.close();
    }

    public static void loadData() throws IOException {
        FileReader fr = new FileReader(JSONFile);

        JsonObject jj = new Gson().fromJson(fr, JsonObject.class);

        fr.close();

        if (jj != null && (!jj.get("buyers").getAsJsonArray().isEmpty() || !jj.get("sellers").getAsJsonArray().isEmpty())) {
            JSONImport.start(jj);
        }
    }
}
