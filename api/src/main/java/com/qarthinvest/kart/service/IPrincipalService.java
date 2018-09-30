package com.qarthinvest.kart.service;

import com.qarthinvest.kart.web.proxy.AdminProxy;
import com.qarthinvest.kart.web.proxy.CommercialProxy;
import com.qarthinvest.kart.web.proxy.CompanyProxy;

import java.security.Principal;

public interface IPrincipalService {

    /**
     * Finds the admin principal.
     */
    AdminProxy getAdminPrincipal(Principal principal);

    /**
     * Finds the company principal.
     */
    CompanyProxy getCompanyPrincipal(Principal principal);

    /**
     * Finds the commercial principal.
     */
    CommercialProxy getCommercialPrincipal(Principal principal);

}
