package com.qarthinvest.kart.web.request;

public class UpdateCompanyRequest {

    private String name;
    private String vat;
    private String phone;
    private String email;
    private boolean enabled;

    public String getName() {
        return name;
    }

    public String getVat() {
        return vat;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
