package com.backend.servicee;

import com.backend.model.Financial_Data;
import com.backend.model.request.AnafRequest;
import com.backend.model.response.AnafResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AnafService {

    private final String ANAF_URL_API = "https://webservicesp.anaf.ro/api/PlatitorTvaRest/v9/tva";
    private final HttpClient client;
    private final Gson gson;

    public AnafService() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public AnafResponse checkAnaf(Integer cui) throws IOException, InterruptedException {
        String dataResponse = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        AnafRequest requestDate = new AnafRequest(cui, dataResponse);

        String jsonPayload = "[" + gson.toJson(requestDate) + "]";
        System.out.println("Send to ANAF: " + jsonPayload);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ANAF_URL_API))
                .header("Content-Type", "application/json")
                .header("User-Agent", "AplicatieVerificareJava/1.9")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String jsonResponse = response.body();
        System.out.println("Received from ANAF: " + jsonResponse);
        return gson.fromJson(jsonResponse, AnafResponse.class);
    }

    public List<Financial_Data> fetchFinancialData(String cui) {
        // TODO: Replace this with a real bilanț API call in the future
        return List.of(
                new Financial_Data(1, 2022, 1_200_000.0, 250_000.0, 3_100_000.0, null),
                new Financial_Data(null, 2021, 1_000_000.0, 210_000.0, 2_900_000.0, null),
                new Financial_Data(null, 2020,   800_000.0, 150_000.0, 2_500_000.0, null)
        );
    }

}
