import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Webservice {

    public JsonObject consultar(String divisa) throws IOException {

        String url_str = "https://v6.exchangerate-api.com/v6/8942777d237f9e572c8d8ce5/latest/"+divisa;

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonElement root = JsonParser.parseReader(new InputStreamReader(request.getInputStream()));
        return root.getAsJsonObject();
    }
}
