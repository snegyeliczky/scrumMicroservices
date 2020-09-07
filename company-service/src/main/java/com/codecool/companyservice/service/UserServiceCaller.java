package com.codecool.companyservice.service;

import com.codecool.companyservice.model.Employee;
import com.codecool.companyservice.model.ProjectData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${apigateway.url}")
    private String baseUrl;

    public Employee getEmployeeFromContext(){
        ResponseEntity<Employee> response = restTemplate.getForEntity(baseUrl + "/get-user", Employee.class);
        Employee employee = response.getBody();
        log.info(employee.toString());
        return employee;
    }
}
