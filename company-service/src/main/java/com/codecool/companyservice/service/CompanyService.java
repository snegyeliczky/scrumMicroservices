package com.codecool.companyservice.service;

import com.codecool.companyservice.model.Company;
import com.codecool.companyservice.model.Employee;
import com.codecool.companyservice.model.ProjectData;
import com.codecool.companyservice.model.credential.CompanyAndProjects;
import com.codecool.companyservice.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProjectServiceCaller projectServiceCaller;

    public ResponseEntity createNewCompany(Company company) {
        try {
            Company newCompany = Company.builder()
                    .name(company.getName())
                    .build();
            companyRepository.save(newCompany);
            return ResponseEntity.ok(true);
        } catch (Exception e){
            return ResponseEntity.ok(false);
        }

    }

    public ResponseEntity addEmployee(Employee employee, UUID companyId) {
        try {
            Company company = companyRepository.findById(companyId).get();
            List<UUID> employeeIds = company.getEmployeeIds();
            employeeIds.add(employee.getId());
            log.info(employeeIds.toString());
            company.setEmployeeIds(employeeIds);
            companyRepository.save(company);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }

    public Company[] companyToUser(Employee employee) {
        return companyRepository.findCompaniesByEmployeeIdsContains(employee.getId());
    }

    public CompanyAndProjects companyAndProjects(Employee employee) {
        Company[] companies = companyRepository.findCompaniesByEmployeeIdsContains(employee.getId());
        Map<UUID,ProjectData[]> projectsForCompany = new HashMap<>();
        for (Company company : companies ){
            ProjectData[] projectsOfCompany = projectServiceCaller.getProjectsForCompany(company.getId());
            projectsForCompany.put(company.getId(),projectsOfCompany);
        }
        return CompanyAndProjects.builder()
                .company(companies)
                .projectsForCompany(projectsForCompany)
                .build();

    }
}
