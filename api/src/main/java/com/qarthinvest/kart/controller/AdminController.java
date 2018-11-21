package com.qarthinvest.kart.controller;

import com.qarthinvest.kart.service.IAdminService;
import com.qarthinvest.kart.service.IPrincipalService;
import com.qarthinvest.kart.web.proxy.AdminProxy;
import com.qarthinvest.kart.web.proxy.CommercialProxy;
import com.qarthinvest.kart.web.proxy.CompanyProxy;
import com.qarthinvest.kart.web.request.AddCommercialRequest;
import com.qarthinvest.kart.web.request.AddCompanyRequest;
import com.qarthinvest.kart.web.request.UpdateCommercialRequest;
import com.qarthinvest.kart.web.request.UpdateCompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

import static com.qarthinvest.kart.util.Constants.ADMIN_API_ROOT;

@RestController
@RequestMapping(value = ADMIN_API_ROOT)
public class AdminController {

    private final IPrincipalService principalService;
    private final IAdminService adminService;

    @Autowired
    public AdminController(IPrincipalService principalService, IAdminService adminService) {
        this.principalService = principalService;
        this.adminService = adminService;
    }

    @GetMapping(value = "/principal")
    public AdminProxy principal(Principal principal) {
        return principalService.getAdminPrincipal(principal);
    }

    @GetMapping(value = "/companies")
    public Page<CompanyProxy> getCompanies(Pageable pageable) {
        return adminService.getCompanies(pageable);
    }

    @PostMapping(value = "/companies")
    public void addCompany(@RequestBody final AddCompanyRequest request) {
        adminService.addCompany(request);
    }

    @GetMapping(value = "/companies/{company}")
    public Optional<CompanyProxy> getCompany(@PathVariable String company) {
        return adminService.getCompany(company);
    }

    @PutMapping(value = "/companies/{company}")
    public CompanyProxy updateCompany(@PathVariable String company, @RequestBody final UpdateCompanyRequest request) {
        return adminService.updateCompany(company, request);
    }

    @GetMapping(value = "/commercials")
    public Page<CommercialProxy> getCommercials(Pageable pageable) {
        return adminService.getCommercials(pageable);
    }

    @PostMapping(value = "/commercials")
    public void addCommercial(@RequestBody final AddCommercialRequest request) {
        adminService.addCommercial(request);
    }

    @GetMapping(value = "/commercials/{commercial}")
    public Optional<CommercialProxy> getCommercial(@PathVariable String commercial) {
        return adminService.getCommercial(commercial);
    }

    @PutMapping(value = "/commercials/{commercial}")
    public void updateCommercial(@PathVariable String commercial, @RequestBody final UpdateCommercialRequest request) {
        adminService.updateCommercial(commercial, request);
    }

}
