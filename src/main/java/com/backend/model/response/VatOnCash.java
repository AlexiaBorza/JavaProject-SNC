package com.backend.model.response;
import com.google.gson.annotations.SerializedName;


public class VatOnCash {
    @SerializedName("are_TVA_la_incasare")
    private Boolean areTvaLaIncasare;

    @SerializedName("data_inceput_TVA_la_incasare")
    private String dataInceput;

    @SerializedName("data_sfarsit_TVA_la_incasare")
    private String dataSfarsit;

    public Boolean getAreTvaLaIncasare() {
        return areTvaLaIncasare;
    }

    public String getDataInceput() {
        return dataInceput;
    }

    public String getDataSfarsit() {
        return dataSfarsit;
    }
}
