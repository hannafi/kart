package com.qarthinvest.kart.service;

import com.qarthinvest.kart.web.proxy.CommercialProxy;
import com.qarthinvest.kart.web.proxy.CompanyProxy;
import com.qarthinvest.kart.web.request.AddCommercialRequest;
import com.qarthinvest.kart.web.request.AddCompanyRequest;
import com.qarthinvest.kart.web.request.UpdateCommercialRequest;
import com.qarthinvest.kart.web.request.UpdateCompanyRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IAdminService {

    /**
     * Get companies.
     */
    Page<CompanyProxy> getCompanies(Pageable pageable);

    /**
     * Get company by id.
     */
    Optional<CompanyProxy> getCompany(String id);

    /**
     * Add company.
     */
    @Transactional(rollbackFor = Exception.class)
    void addCompany(AddCompanyRequest request);

    /**
     * Update company.
     */
    @Transactional(rollbackFor = Exception.class)
    void updateCompany(String company, UpdateCompanyRequest request);

    /**
     * Get commercials.
     */
    Page<CommercialProxy> getCommercials(Pageable pageable);

    /**
     * Get commercial by id.
     */
    Optional<CommercialProxy> getCommercial(String id);

    /**
     * Add commercial.
     */
    @Transactional(rollbackFor = Exception.class)
    void addCommercial(AddCommercialRequest request);

    /**
     * Update commercial.
     */
    @Transactional(rollbackFor = Exception.class)
    void updateCommercial(String commercial, UpdateCommercialRequest request);

}
