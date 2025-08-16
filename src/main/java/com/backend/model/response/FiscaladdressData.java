package com.backend.model.response;
import com.google.gson.annotations.SerializedName;

public class FiscaladdressData {
    @SerializedName("adresa")
    private String adresa;

    public String getAdresa() {
        return adresa;
    }
}
