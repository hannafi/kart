package com.qarthinvest.kart.web.proxy;

import com.qarthinvest.kart.domain.Admin;

import java.time.LocalDateTime;

public class AdminProxy {

    private String id;
    private String email;
    private LocalDateTime creationDate;
    private LocalDateTime lastLoginDate;

    public AdminProxy(Admin admin) {
        this.id = admin.getId();
        this.email = admin.getEmail();
        this.creationDate = admin.getCreationDate();
        this.lastLoginDate = admin.getLastLoginDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
