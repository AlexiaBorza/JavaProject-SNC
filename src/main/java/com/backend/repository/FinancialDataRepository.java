package com.backend.repository;

import com.backend.model.Financial_Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialDataRepository extends JpaRepository<Financial_Data, Long> {}
