package com.qarthinvest.kart.controller;

import com.qarthinvest.kart.web.proxy.CommercialProxy;
import com.qarthinvest.kart.web.proxy.CompanyProxy;
import com.qarthinvest.kart.repository.CommercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

import static com.qarthinvest.kart.util.Constants.COMMERCIAL_API_ROOT;


@RestController
@RequestMapping(value = COMMERCIAL_API_ROOT)
public class CommercialController {

    private final CommercialRepository commercialRepository;

    @Autowired
    public CommercialController(CommercialRepository commercialRepository) {
        this.commercialRepository = commercialRepository;
    }

    @GetMapping(value = "/principal")
    public Optional<CommercialProxy> principal(Principal principal) {
        return commercialRepository.findById(principal.getName()).map(CommercialProxy::new);
    }

}
