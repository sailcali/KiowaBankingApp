package Connectors;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AnnualConnector {

    public AnnualExpenseDTO[] annualExpenses;


    public void getAnnuals(String apiKey) {
        HttpClient client = HttpClient.newHttpClient();

        //GET
        try {
            HttpResponse<String> response = client.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8080/banking-api/annuals"))
                    .header("Authorization", apiKey)
                    .build(), HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 401) {
                throw new IOException("Not Authorized");
            }
            ObjectMapper mapper = new ObjectMapper();
            annualExpenses = mapper.readValue(response.body(), AnnualExpenseDTO[].class);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
