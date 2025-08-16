package com.backend.model.response;
import com.google.gson.annotations.SerializedName;

public class TVAPeriod {
    @SerializedName("data_inceput_TVA")
    private String dataInceput;

    @SerializedName("data_sfarsit_TVA")
    private String dataSfarsit;

    public String getDataInceput() {
        return dataInceput;
    }

    public String getDataSfarsit() {
        return dataSfarsit;
    }
}
