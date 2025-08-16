package com.backend;

import com.backend.model.response.AnafResponse;
import com.backend.model.response.FoundCompany;
import com.backend.model.response.GeneralData;
import com.backend.servicee.AnafService;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;
import com.backend.model.response.Utils;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnafService service = new AnafService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the CUI: ");
        String cuiIntrodus = scanner.nextLine();

        int year = Utils.getYear();
        System.out.println("Available ANAF year: " + year);

        try {
            Integer cui = Integer.parseInt(cuiIntrodus);
            AnafResponse response = service.checkAnaf(cui);

            if (response != null && response.getFound() != null && !response.getFound().isEmpty()) {
                FoundCompany firma = response.getFound().get(0);
                printCompanyDetails(firma);
            } else {
                System.out.println("\n The CUI '" + cuiIntrodus + "' was not found or is invalid.");
            }

        } catch (NumberFormatException e) {
            System.err.println("\nERROR: The CUI must contain only digits.");
        } catch (Exception e) {
            System.err.println("\n An unexpected error occurred!");
            System.err.println("Reason: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printCompanyDetails(FoundCompany firma) {
        GeneralData dateGenerale = firma.getDateGenerale();
        System.out.println("\nCUI VERIFICATION RESULTS\n");

        if (dateGenerale != null) {
            System.out.println("General Data:");
            System.out.println("Name: " + dateGenerale.getName());
            System.out.println("Fiscal Address: " + dateGenerale.getFiscalAddress());
            System.out.println("Trade Register No.: " + dateGenerale.getTradeRegisterNumber());
            System.out.println("Phone: " + dateGenerale.getPhone());
            System.out.println("Fax: " + dateGenerale.getFax());
            System.out.println("Postal Code: " + dateGenerale.getPostalCode());
            System.out.println("Authorization Act: " + dateGenerale.getAuthorizationAct());
            System.out.println("Registration Status: " + dateGenerale.getRegistrationStatus());
        } else {
            System.out.println(" No general data returned for this CUI.");
        }
    }
}