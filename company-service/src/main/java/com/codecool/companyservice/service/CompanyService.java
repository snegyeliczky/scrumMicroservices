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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Company companyToUser(Employee employee) {
        return companyRepository.findCompanyByEmployeeIdsContains(employee.getId());
    }

    public CompanyAndProjects companyAndProjects(Employee employee) {
        Company company = companyRepository.findCompanyByEmployeeIdsContains(employee.getId());
        ProjectData[] projectsForCompany = projectServiceCaller.getProjectsForCompany(company.getId());
        return CompanyAndProjects.builder()
                .company(company)
                .projectData(projectsForCompany)
                .build();

    }
}
