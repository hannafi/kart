package com.qarthinvest.kart.controller;

import com.qarthinvest.kart.repository.CompanyRepository;
import com.qarthinvest.kart.web.proxy.CompanyProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

import static com.qarthinvest.kart.util.Constants.COMPANY_API_ROOT;


@RestController
@RequestMapping(value = COMPANY_API_ROOT)
public class CompanyController {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping(value = "/principal")
    public Optional<CompanyProxy> principal(Principal principal) {
        return companyRepository.findById(principal.getName()).map(CompanyProxy::new);
    }

}
