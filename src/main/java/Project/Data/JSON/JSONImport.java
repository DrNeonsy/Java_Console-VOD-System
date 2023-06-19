package Project.Data.JSON;

import Project.Classes.Buyer;
import Project.Classes.Seller;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import static Project.Classes.Application.USERS;

public class JSONImport {
    public static void start(JsonObject jj) {
        JsonArray buyers;
        JsonArray sellers;

        buyers = jj.get("buyers").getAsJsonArray();
        sellers = jj.get("sellers").getAsJsonArray();

        HashMap<Object, Object> base = new HashMap<>() {{
            put("TRANSACTIONS", null);
            put("name", null);
            put("lastname", null);
            put("email", null);
            put("password", null);
            put("phone", null);
            put("address", null);
            put("city", null);
            put("zip", null);
            put("country", null);
        }};

        for (int i = 0; i < buyers.size(); i++) {
            HashMap<Object, Object> data = new HashMap<>() {{
                putAll(base);
                put("buyerID", null);
                put("creditCardNumber", null);
                put("creditCardExpiration", null);
                put("creditCardCVV", null);
                put("TRANSACTIONS", null);
            }};

            for (Map.Entry<String, JsonElement> e : buyers.get(i).getAsJsonObject().entrySet()) {
                if (!e.getKey().equals("TRANSACTION")) {
                    if (!buyers.get(i).getAsJsonObject().get(e.getKey()).isJsonNull()) {
                        data.replace(e.getKey(), null, e.getValue().getAsString());
                    }
                }
            }

            USERS.add(new Buyer(data));

        }

        for (int i = 0; i < sellers.size(); i++) {
            HashMap<Object, Object> data = new HashMap<>() {{
                putAll(base);
                put("sellerID", null);
            }};

            for (Map.Entry<String, JsonElement> e : sellers.get(i).getAsJsonObject().entrySet()) {
                if (!sellers.get(i).getAsJsonObject().get(e.getKey()).isJsonNull()) {
                    data.replace(e.getKey(), null, e.getValue().getAsString());
                }
            }

            USERS.add(new Seller(data));
        }
    }
}
