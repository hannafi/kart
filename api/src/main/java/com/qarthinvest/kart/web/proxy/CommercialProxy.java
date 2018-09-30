package com.qarthinvest.kart.web.proxy;

import com.qarthinvest.kart.domain.Commercial;

import java.time.LocalDateTime;

public class CommercialProxy {

    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String companyId;
    private String companyName;
    private LocalDateTime creationDate;
    private LocalDateTime lastLoginDate;

    public CommercialProxy(Commercial commercial) {
        this.id = commercial.getId();
        this.firstname = commercial.getFirstname();
        this.lastname = commercial.getLastname();
        this.phone = commercial.getPhone();
        this.email = commercial.getEmail();
        this.creationDate = commercial.getCreationDate();
        this.lastLoginDate = commercial.getLastLoginDate();
        this.companyId = commercial.getCompany().getId();
        this.companyName = commercial.getCompany().getName();
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }
}
