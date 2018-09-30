package com.qarthinvest.kart.web.proxy;

import com.qarthinvest.kart.domain.Company;

import java.time.LocalDateTime;

public class CompanyProxy {

    private String id;
    private String name;
    private String vat;
    private String phone;
    private String email;
    private LocalDateTime creationDate;
    private LocalDateTime lastLoginDate;

    public CompanyProxy(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.vat = company.getVat();
        this.phone = company.getPhone();
        this.email = company.getEmail();
        this.creationDate = company.getCreationDate();
        this.lastLoginDate = company.getLastLoginDate();
    }

    public String getId() {
        return id;
    }

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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

}
