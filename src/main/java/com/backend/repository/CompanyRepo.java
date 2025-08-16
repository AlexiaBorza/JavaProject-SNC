package com.backend.repository;
import com.backend.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepo extends JpaRepository<Company, Integer> {}
