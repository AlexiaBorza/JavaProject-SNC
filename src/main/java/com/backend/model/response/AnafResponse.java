package com.backend.model.response;

import java.util.List;

public class AnafResponse {
    private String cod;
    private String data;
    private List<FoundCompany> found;

    public String getCod() {
        return cod;
    }

    public String getData() {
        return data;
    }
    public List<FoundCompany> getFound() {
        return found;
    }

}
