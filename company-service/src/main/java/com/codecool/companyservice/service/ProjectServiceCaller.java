package com.codecool.companyservice.service;

import com.codecool.companyservice.model.ProjectData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ProjectServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value ("${project-service.url}")
    private String baseUrl;

    public ProjectData[] getAllProject(){
        ResponseEntity<ProjectData[]> response = restTemplate.getForEntity(baseUrl + "/all", ProjectData[].class);
        ProjectData[] body = response.getBody();
        log.info(Arrays.toString(body));
        return body;
    }

    public ProjectData[] getProjectsForCompany(UUID companyId){
        ResponseEntity<ProjectData[]> response = restTemplate.getForEntity(baseUrl + "/" + companyId, ProjectData[].class);
        ProjectData[] body = response.getBody();
        return body;

    }

}

