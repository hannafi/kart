package com.qarthinvest.kart.repository;

import com.qarthinvest.kart.domain.Admin;

import java.util.Optional;

public interface AdminRepository extends AccountBaseRepository<Admin> {
    Optional<Admin> findByEmail(String username);
}
