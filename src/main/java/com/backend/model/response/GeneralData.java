package com.backend.model.response;
import com.google.gson.annotations.SerializedName;

public class GeneralData {
    @SerializedName("denumire")
    private String name;

    @SerializedName("adresa")
    private String fiscalAddress;

    @SerializedName("nrRegCom")
    private String tradeRegisterNumber;

    @SerializedName("telefon")
    private String phone;

    @SerializedName("fax")
    private String fax;

    @SerializedName("codPostal")
    private String postalCode;

    @SerializedName("act")
    private String authorizationAct;

    @SerializedName("statusRegCom")
    private String registrationStatus;

    @SerializedName("dataInregRegCom")
    private String registrationDate;

    public String getName() {
        return name;
    }

    public String getFiscalAddress() {
        return fiscalAddress;
    }

    public String getTradeRegisterNumber() {
        return tradeRegisterNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAuthorizationAct() {
        return authorizationAct;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }
}
