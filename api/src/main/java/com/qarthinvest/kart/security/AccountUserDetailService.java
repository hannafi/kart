package com.qarthinvest.kart.security;

import com.qarthinvest.kart.domain.Account;
import com.qarthinvest.kart.repository.AccountRepository;
import com.qarthinvest.kart.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountUserDetailService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountUserDetailService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account found = accountRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No local user with username " + username));

        found.setLastLoginDate(Utils.utcDateTime());
        accountRepository.save(found);

        RoleType roleType = RoleType.valueOf(found.getRole());
        Collection<GrantedAuthority> authorityList = Collections.singletonList(new SimpleGrantedAuthority(roleType.name()));
        return new org.springframework.security.core.userdetails.User(
                found.getUsername(),
                found.getPassword(),
                found.isEnabled(),
                true,
                true,
                true,
                authorityList);

    }
}
