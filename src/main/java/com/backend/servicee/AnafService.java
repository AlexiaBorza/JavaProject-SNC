package com.backend.servicee;

import com.backend.model.Financial_Data;
import com.backend.model.request.AnafRequest;
import com.backend.model.response.AnafResponse;
import com.backend.repository.FinancialDataRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AnafService {

    private final String ANAF_URL_API = "https://webservicesp.anaf.ro/api/PlatitorTvaRest/v9/tva";
    private final HttpClient client;
    private final Gson gson;

    @Autowired
    private FinancialDataRepository financialDataRepository;

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
        return financialDataRepository.findByCompany_Cui(cui);
    }

}
