package com.qarthinvest.kart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "KART_COMPANY")
public class Company extends Account {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "VAT", nullable = false)
    private String vat;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    private Company() {
    }

    private Company(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.vat = builder.vat;
        this.lastLoginDate = builder.lastLoginDate;
        this.username = builder.username;
        this.password = builder.password;
        this.creationDate = builder.creationDate;
        this.enabled = builder.enabled;
        this.role = builder.role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Company Builder
     */
    public static class Builder {

        private String id;
        private String vat;
        private String name;
        private String email;
        private String phone;
        private LocalDateTime lastLoginDate;
        private LocalDateTime creationDate;
        private String username;
        private String password;
        private boolean enabled;
        private String role;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder vat(String vat) {
            this.vat = vat;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder lastLoginDate(LocalDateTime lastModifiedDate) {
            this.lastLoginDate = lastModifiedDate;
            return this;
        }

        public Builder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }
}
