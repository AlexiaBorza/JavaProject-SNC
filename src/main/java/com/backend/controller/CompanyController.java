package com.backend.controller;

import com.backend.model.Company;
import com.backend.repository.CompanyRepo;
import com.backend.servicee.AnafService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/firma")
@RequiredArgsConstructor
public class CompanyController {

    private final AnafService anafService;
    private final CompanyRepo companyRepository;

    @GetMapping("/{cui}")
    public ResponseEntity<Company> getCompany(@PathVariable String cui) {
        Company company = AnafService.fetchCompanyData(cui);
        companyRepository.save(company);
        return ResponseEntity.ok(company);
    }
}
