import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {


    public Endereco buscaEndereco(String cep) {
        try {
            URI enderecoURL = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(enderecoURL)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            return new Gson().fromJson(responseBody, Endereco.class);

        } catch (Exception e) {
            throw new RuntimeException("CEP Inválido!");
        }
    }
}