import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public TasaDeCambio buscaTasaDeCambio(String monedaBase) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/89649a93c7f35eea2cba9d8b/latest/" + monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TasaDeCambio.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las tasas de cambio.");
        }
    }
}
