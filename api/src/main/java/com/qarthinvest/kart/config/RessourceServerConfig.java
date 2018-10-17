package com.qarthinvest.kart.config;

import com.qarthinvest.kart.security.RoleType;
import com.qarthinvest.kart.util.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class RessourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .requestMatchers()
                .antMatchers(
                        Constants.ADMIN_API_ROOT + "/**",
                        Constants.COMPANY_API_ROOT + "/**",
                        Constants.COMMERCIAL_API_ROOT + "/**"
                )
                .and()
                .authorizeRequests()
                .antMatchers(Constants.ADMIN_API_ROOT + "/**").hasAuthority(RoleType.ROLE_ADMIN.name())
                .and()
                .authorizeRequests()
                .antMatchers(Constants.COMPANY_API_ROOT + "/**").hasAuthority(RoleType.ROLE_MANAGER_COMPANY.name())
                .and()
                .authorizeRequests()
                .antMatchers(Constants.COMMERCIAL_API_ROOT + "/**").hasAuthority(RoleType.ROLE_COMMERCIAL.name())
                .and()
                .authorizeRequests()
                .anyRequest().hasAuthority(RoleType.ROLE_ADMIN.name());
    }

}