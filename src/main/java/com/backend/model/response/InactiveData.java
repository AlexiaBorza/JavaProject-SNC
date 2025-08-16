package com.backend.model.response;
import com.google.gson.annotations.SerializedName;

public class InactiveData {
    @SerializedName("data_inactivare")
    private String dataInactivare;

    @SerializedName("data_reactivare")
    private String dataReactivare;

    @SerializedName("data_publicare")
    private String dataPublicare;

    public String getDataInactivare() {
        return dataInactivare;
    }

    public String getDataReactivare() {
        return dataReactivare;
    }

    public String getDataPublicare() {
        return dataPublicare;
    }
}
