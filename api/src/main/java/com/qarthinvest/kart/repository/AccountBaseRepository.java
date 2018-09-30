package com.qarthinvest.kart.repository;

import com.qarthinvest.kart.domain.Account;
import com.qarthinvest.kart.domain.Commercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface AccountBaseRepository<T extends Account> extends JpaRepository<T, String> {

    Optional<T> findByUsername(String username);

}
