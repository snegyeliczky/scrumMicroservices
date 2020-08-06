package com.codecool.companyservice.conroller;

import com.codecool.companyservice.model.Company;
import com.codecool.companyservice.model.Employee;
import com.codecool.companyservice.model.ProjectData;
import com.codecool.companyservice.model.credential.CompanyAndProjects;
import com.codecool.companyservice.service.CompanyService;
import com.codecool.companyservice.service.ProjectServiceCaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@Slf4j
public class CompanyController {

    @Autowired
    private ProjectServiceCaller projectServiceCaller;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private Environment env;


    private void logInfo(){
        log.info("port: "+env.getProperty("server.port")+" called at: "+ LocalDateTime.now());
    }

    @PostMapping("/create-company")
    public ResponseEntity createNewCompany(@RequestBody Company company){
        return companyService.createNewCompany(company);
    }

    @PostMapping("/add-employee/{companyId}")
    public ResponseEntity addEmployee(@RequestBody Employee employee, @PathVariable UUID companyId){
        return companyService.addEmployee(employee,companyId);
    }

    @PostMapping("/company-for-user")
    public Company companyToUser(@RequestBody Employee employee){
        return companyService.companyToUser(employee);
    }

    @PostMapping("/company-with-projects")
    public CompanyAndProjects companyAndProjects(@RequestBody Employee employee){
        return companyService.companyAndProjects(employee);
    }

    @GetMapping("/all-project")
    public ProjectData[] getAllProject(){
        logInfo();
        return projectServiceCaller.getAllProject();
    }



}
