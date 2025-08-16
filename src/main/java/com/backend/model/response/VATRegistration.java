package com.backend.model.response;
import com.google.gson.annotations.SerializedName;

public class VATRegistration {
    @SerializedName("data_inregistrare_TVA")
    private String dataInregistrare;

    @SerializedName("data_anulare_TVA")
    private String dataAnulare;

    public String getDataInregistrare() {
        return dataInregistrare;
    }

    public String getDataAnulare() {
        return dataAnulare;
    }
}
