package com.qarthinvest.kart.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {

    @Id
    @Column(name = "ID")
    String id;

    @Column(name = "USERNAME", unique = true)
    String username;

    @Column(name = "PASSWORD", nullable = false)
    String password;

    @Column(name = "CREATION_TIME", nullable = false)
    LocalDateTime creationDate;

    @Column(name = "LAST_LOGIN_TIME")
    LocalDateTime lastLoginDate;

    @Column(name = "ENABLED", nullable = false)
    boolean enabled;

    @Column(name = "ROLE", nullable = false)
    String role;

    Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
