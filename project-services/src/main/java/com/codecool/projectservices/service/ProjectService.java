package com.codecool.projectservices.service;

import com.codecool.projectservices.model.Project;
import com.codecool.projectservices.model.credentials.ProjectCredential;
import com.codecool.projectservices.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ResponseEntity createNewProject(ProjectCredential project) {
        try {
            Project newProject = new Project();
            newProject.setName(project.getProjectName());
            projectRepository.save(newProject);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            return ResponseEntity.ok(e);
        }
    }

    public List<Project> getAllProject() {
        return  projectRepository.findAll();
    }
}
