package com.qarthinvest.kart.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "KART_COMMERCIAL")
public class Commercial extends Account {

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Column(name = "LASTNAME", nullable = false)
    private String lastname;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    private Company company;

    private Commercial() {
    }

    private Commercial(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.phone = builder.phone;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.lastLoginDate = builder.lastLoginDate;
        this.username = builder.username;
        this.password = builder.password;
        this.creationDate = builder.creationDate;
        this.enabled = builder.enabled;
        this.role = builder.role;
        this.company = builder.company;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commercial commercial = (Commercial) o;
        return Objects.equals(id, commercial.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Commercial Builder
     */
    public static class Builder {

        private String id;
        private String firstname;
        private String lastname;
        private String email;
        private String phone;
        private LocalDateTime lastLoginDate;
        private String username;
        private String password;
        private LocalDateTime creationDate;
        private boolean enabled;
        private String role;
        private Company company;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
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

        public Builder company(Company company) {
            this.company = company;
            return this;
        }

        public Commercial build() {
            return new Commercial(this);
        }
    }
}
