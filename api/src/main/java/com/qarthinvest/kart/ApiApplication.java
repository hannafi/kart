package com.qarthinvest.kart;

import com.qarthinvest.kart.repository.CommercialRepository;
import com.qarthinvest.kart.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CommercialRepository commercialRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
