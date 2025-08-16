package com.backend.model.response;

import com.google.gson.annotations.SerializedName;

public class FoundCompany {

    @SerializedName("date_generale")
    private GeneralData dateGenerale;

    public GeneralData getDateGenerale() {
        return dateGenerale;
    }

    public void setDateGenerale(GeneralData dateGenerale) {
        this.dateGenerale = dateGenerale;
    }
}
