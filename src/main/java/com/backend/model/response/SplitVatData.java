package com.backend.model.response;
import com.google.gson.annotations.SerializedName;

public class SplitVatData {
    @SerializedName("are_splitTVA")
    private Boolean areSplitTVA;

    @SerializedName("data_inceput_SplitTVA")
    private String dataInceput;

    @SerializedName("data_sfarsit_SplitTVA")
    private String dataSfarsit;

    public Boolean getAreSplitTVA() {
        return areSplitTVA;
    }

    public String getDataInceput() {
        return dataInceput;
    }

    public String getDataSfarsit() {
        return dataSfarsit;
    }
}
