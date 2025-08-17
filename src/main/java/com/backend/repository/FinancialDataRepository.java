package com.backend.repository;

import com.backend.model.Financial_Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialDataRepository extends JpaRepository<Financial_Data, Long> {
    List<Financial_Data> findByCompany_Cui(String cui);
}
