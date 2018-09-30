package com.qarthinvest.kart.config;

import com.qarthinvest.kart.security.AccountUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorisationServeConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final AccountUserDetailService accountUserDetailService;

    @Autowired
    public AuthorisationServeConfig(AuthenticationConfiguration authenticationConfiguration, AccountUserDetailService accountUserDetailService) throws Exception {
        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
        this.accountUserDetailService = accountUserDetailService;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
                .userDetailsService(accountUserDetailService)
                .accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager);
    }

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("kart")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600)
                .secret("{noop}kart")
                .scopes("read", "write");
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("JRh.G%T=6M,%]_1_x{E(~w[?D3b0dt");
        return converter;
    }

}
