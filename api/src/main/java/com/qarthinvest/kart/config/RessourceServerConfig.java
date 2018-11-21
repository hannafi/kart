package com.qarthinvest.kart.config;

import com.qarthinvest.kart.security.RoleType;
import com.qarthinvest.kart.util.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import static com.qarthinvest.kart.util.Constants.ADMIN_API_ROOT;
import static com.qarthinvest.kart.util.Constants.COMMERCIAL_API_ROOT;
import static com.qarthinvest.kart.util.Constants.COMPANY_API_ROOT;

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
                        COMPANY_API_ROOT + "/**",
                        COMMERCIAL_API_ROOT + "/**"
                )
                .and()
                .authorizeRequests()
                .antMatchers(ADMIN_API_ROOT + "/recover").permitAll()
                .antMatchers(ADMIN_API_ROOT + "/**").hasAuthority(RoleType.ROLE_ADMIN.name())
                .and()
                .authorizeRequests()
                .antMatchers(COMPANY_API_ROOT + "/**").hasAuthority(RoleType.ROLE_MANAGER_COMPANY.name())
                .and()
                .authorizeRequests()
                .antMatchers(COMMERCIAL_API_ROOT + "/**").hasAuthority(RoleType.ROLE_COMMERCIAL.name())
                .and()
                .authorizeRequests()
                .anyRequest().hasAuthority(RoleType.ROLE_ADMIN.name());
    }

}