import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda buscaMoneda(String tipoCambio,String tipoCambio2, double monto){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/91a3dccc20ecb0e8e0cd3f67/pair/"+tipoCambio+"/"+tipoCambio2+"/"+monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("No encontré tu tipo de cambio");
        }

        return new Gson().fromJson(response.body(),Moneda.class);
    }
}