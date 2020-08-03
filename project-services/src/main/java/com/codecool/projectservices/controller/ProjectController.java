package com.codecool.projectservices.controller;

import com.codecool.projectservices.model.Project;
import com.codecool.projectservices.model.credentials.ProjectCredential;
import com.codecool.projectservices.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(allowCredentials = "true")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/new")
    public ResponseEntity createNewProject(@RequestBody ProjectCredential project){
        return projectService.createNewProject(project);
    }

    @GetMapping("/all")
    public List<Project> getAllProject(){
        return projectService.getAllProject();
    }
}
