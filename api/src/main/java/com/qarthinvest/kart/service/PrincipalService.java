package com.qarthinvest.kart.service;

import com.qarthinvest.kart.web.proxy.AdminProxy;
import com.qarthinvest.kart.web.proxy.CommercialProxy;
import com.qarthinvest.kart.web.proxy.CompanyProxy;
import com.qarthinvest.kart.repository.AdminRepository;
import com.qarthinvest.kart.repository.CommercialRepository;
import com.qarthinvest.kart.repository.CompanyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class PrincipalService implements IPrincipalService {

    private static final Logger LOGGER = LogManager.getLogger(PrincipalService.class.getName());

    private final CommercialRepository commercialRepository;
    private final CompanyRepository companyRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public PrincipalService(CommercialRepository commercialRepository, CompanyRepository companyRepository, AdminRepository adminRepository) {
        this.commercialRepository = commercialRepository;
        this.companyRepository = companyRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminProxy getAdminPrincipal(Principal principal) {
        LOGGER.info("Fetching Admin Principal with id {}", principal.getName());
        return adminRepository.findById(principal.getName())
                .map(AdminProxy::new)
                .orElseThrow(() -> new IllegalStateException("Principal admin with id " + principal.getName() + " not found!"));
    }

    @Override
    public CompanyProxy getCompanyPrincipal(Principal principal) {
        LOGGER.info("Fetching Company Principal with id {}", principal.getName());
        return companyRepository.findById(principal.getName())
                .map(CompanyProxy::new)
                .orElseThrow(() -> new IllegalStateException("Principal company with id " + principal.getName() + " not found!"));
    }

    @Override
    public CommercialProxy getCommercialPrincipal(Principal principal) {
        LOGGER.info("Fetching Commercial Principal with id {}", principal.getName());
        return commercialRepository.findById(principal.getName())
                .map(CommercialProxy::new)
                .orElseThrow(() -> new IllegalStateException("Principal commercial with id " + principal.getName() + " not found!"));
    }
}
