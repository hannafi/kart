package com.qarthinvest.kart.service;

import com.qarthinvest.kart.domain.Commercial;
import com.qarthinvest.kart.domain.Company;
import com.qarthinvest.kart.repository.CommercialRepository;
import com.qarthinvest.kart.repository.CompanyRepository;
import com.qarthinvest.kart.security.RoleType;
import com.qarthinvest.kart.util.Utils;
import com.qarthinvest.kart.web.proxy.CommercialProxy;
import com.qarthinvest.kart.web.proxy.CompanyProxy;
import com.qarthinvest.kart.web.request.AddCommercialRequest;
import com.qarthinvest.kart.web.request.AddCompanyRequest;
import com.qarthinvest.kart.web.request.UpdateCommercialRequest;
import com.qarthinvest.kart.web.request.UpdateCompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.qarthinvest.kart.util.Utils.canUpdate;

@Service
public class AdminService implements IAdminService {

    private final PasswordEncoder passwordEncoder;
    private final CommercialRepository commercialRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public AdminService(PasswordEncoder passwordEncoder, CommercialRepository commercialRepository, CompanyRepository companyRepository) {
        this.passwordEncoder = passwordEncoder;
        this.commercialRepository = commercialRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Page<CompanyProxy> getCompanies(Pageable pageable) {
        return companyRepository.findAll(pageable).map(CompanyProxy::new);
    }

    @Override
    public Optional<CompanyProxy> getCompany(String id) {
        return companyRepository.findById(id).map(CompanyProxy::new);
    }

    @Override
    public void addCompany(AddCompanyRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Company company = new Company.Builder()
                .id(Utils.id())
                .name(request.getName())
                .email(request.getEmail())
                .vat(request.getVat())
                .phone(request.getPhone())
                .username(request.getUsername())
                .password(encodedPassword)
                .enabled(true)
                .role(RoleType.ROLE_MANAGER_COMPANY.name())
                .creationDate(Utils.utcDateTime())
                .build();
        companyRepository.save(company);
    }

    @Override
    public CompanyProxy updateCompany(String id, UpdateCompanyRequest request) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No company found for id " + id));

        if (canUpdate(request.getName())) {
            company.setName(request.getName());
        }

        if (canUpdate(request.getVat())) {
            company.setVat(request.getVat());
        }

        if (canUpdate(request.getEmail())) {
            company.setEmail(request.getEmail());
        }

        if (canUpdate(request.getPhone())) {
            company.setPhone(request.getPhone());
        }

        company.setEnabled(request.isEnabled());

        companyRepository.save(company);

        return new CompanyProxy(company);
    }

    @Override
    public Page<CommercialProxy> getCommercials(Pageable pageable) {
        return commercialRepository.findAll(pageable).map(CommercialProxy::new);
    }

    @Override
    public Optional<CommercialProxy> getCommercial(String id) {
        return commercialRepository.findById(id).map(CommercialProxy::new);
    }

    @Override
    public void addCommercial(AddCommercialRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Commercial commercial = new Commercial.Builder()
                .id(Utils.id())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .company(new Company.Builder().id(request.getCompany()).build())
                .phone(request.getPhone())
                .username(request.getUsername())
                .password(encodedPassword)
                .enabled(true)
                .role(RoleType.ROLE_COMMERCIAL.name())
                .creationDate(Utils.utcDateTime())
                .build();
        commercialRepository.save(commercial);
    }

    @Override
    public void updateCommercial(String id, UpdateCommercialRequest request) {
        Commercial commercial = commercialRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No commercial found for id " + id));

        if (canUpdate(request.getFirstname())) {
            commercial.setFirstname(request.getFirstname());
        }

        if (canUpdate(request.getLastname())) {
            commercial.setLastname(request.getLastname());
        }

        if (canUpdate(request.getEmail())) {
            commercial.setEmail(request.getEmail());
        }

        if (canUpdate(request.getPhone())) {
            commercial.setPhone(request.getPhone());
        }

        commercialRepository.save(commercial);
    }
}

