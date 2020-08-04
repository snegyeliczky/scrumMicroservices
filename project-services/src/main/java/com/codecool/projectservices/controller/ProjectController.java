package com.codecool.projectservices.controller;

import com.codecool.projectservices.model.Project;
import com.codecool.projectservices.model.credentials.ProjectCredential;
import com.codecool.projectservices.service.ProjectService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(allowCredentials = "true")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private Environment env;

    private void logInfo(){
        log.info("port: "+env.getProperty("server.port")+" called at: "+LocalDateTime.now());
    }

    @PostMapping("/new")
    public ResponseEntity createNewProject(@RequestBody ProjectCredential project){
        return projectService.createNewProject(project);
    }

    @GetMapping("/all")
    public List<Project> getAllProject(){
        logInfo();
        return projectService.getAllProject();
    }
}
