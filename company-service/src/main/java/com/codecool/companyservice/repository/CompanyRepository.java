package com.codecool.companyservice.repository;

import com.codecool.companyservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Company findCompanyByEmployeeIdsContains(UUID employeeId);
}