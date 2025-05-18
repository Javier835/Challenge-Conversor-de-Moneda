import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Webservice {

    public JsonObject consultar(String divisa) throws IOException {

        // 1. Construcción dinámica de la URL según la divisa solicitada
        String url_str = "https://v6.exchangerate-api.com/v6/8942777d237f9e572c8d8ce5/latest/"+divisa;

        // 2. Apertura de la conexión HTTP
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect(); // Establece la conexión (lanza IOException si falla)

        // 3. Parseo del cuerpo de la respuesta a JSON con la librería Gson
        JsonElement root = JsonParser.parseReader(new InputStreamReader(request.getInputStream()));

        // 4. Se devuelve el objeto JSON
        return root.getAsJsonObject();
    }
}
