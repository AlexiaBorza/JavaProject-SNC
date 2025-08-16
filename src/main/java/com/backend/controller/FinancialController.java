package com.backend.controller;

import com.backend.model.Company;
import com.backend.model.Financial_Data;
import com.backend.repository.CompanyRepo;
import com.backend.repository.FinancialDataRepository;
import com.backend.servicee.AnafService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/bilant")
@RequiredArgsConstructor
public class FinancialController {

    private final AnafService anafService;
    private final FinancialDataRepository financialRepo;
    private final CompanyRepo companyRepo;

    @GetMapping("/{cui}")
    public ResponseEntity<List<Financial_Data>> getFinancial(@PathVariable String cui) {
        Company company = companyRepo.findById(Integer.valueOf(cui)).orElse(null);
        if (company == null) return ResponseEntity.notFound().build();

        List<Financial_Data> list = anafService.fetchFinancialData(cui);
        list.forEach(fd -> fd.setCompany(company));
        financialRepo.saveAll(list);
        return ResponseEntity.ok(list);
    }
}

