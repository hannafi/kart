package com.qarthinvest.kart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "KART_ADMIN")
public class Admin extends Account {

    @Column(name = "EMAIL", nullable = false)
    private String email;

    Admin() {
    }

    private Admin(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.lastLoginDate = builder.lastLoginDate;
        this.username = builder.username;
        this.password = builder.password;
        this.creationDate = builder.creationDate;
        this.enabled = builder.enabled;
        this.role = builder.role;
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
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Admin Builder
     */
    public static class Builder {

        private String id;
        private String email;
        private LocalDateTime lastLoginDate;
        private String username;
        private String password;
        private LocalDateTime creationDate;
        private boolean enabled;
        private String role;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
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

        public Admin build() {
            return new Admin(this);
        }
    }
}
