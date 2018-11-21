package com.qarthinvest.kart.service;

import com.qarthinvest.kart.domain.Admin;
import com.qarthinvest.kart.exception.AccountNotFoundException;
import com.qarthinvest.kart.repository.AdminRepository;
import com.qarthinvest.kart.repository.CommercialRepository;
import com.qarthinvest.kart.repository.CompanyRepository;
import com.qarthinvest.kart.web.proxy.AdminProxy;
import com.qarthinvest.kart.web.proxy.CommercialProxy;
import com.qarthinvest.kart.web.proxy.CompanyProxy;
import com.qarthinvest.kart.web.request.RecoverPasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class PrincipalService implements IPrincipalService {

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
        return adminRepository.findByUsername(principal.getName())
                .map(AdminProxy::new)
                .orElseThrow(() -> new IllegalStateException("Principal admin with id " + principal.getName() + " not found!"));
    }

    @Override
    public CompanyProxy getCompanyPrincipal(Principal principal) {
        return companyRepository.findByUsername(principal.getName())
                .map(CompanyProxy::new)
                .orElseThrow(() -> new IllegalStateException("Principal company with id " + principal.getName() + " not found!"));
    }

    @Override
    public CommercialProxy getCommercialPrincipal(Principal principal) {
        return commercialRepository.findByUsername(principal.getName())
                .map(CommercialProxy::new)
                .orElseThrow(() -> new IllegalStateException("Principal commercial with id " + principal.getName() + " not found!"));
    }

    @Override
    public void recoverAdminPassword(RecoverPasswordRequest request) throws AccountNotFoundException {
        adminRepository.findByEmail(request.getEmail()).orElseThrow(AccountNotFoundException::new);
    }
}
