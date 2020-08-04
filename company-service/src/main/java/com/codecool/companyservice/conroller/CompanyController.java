package com.codecool.companyservice.conroller;

import com.codecool.companyservice.model.ProjectData;
import com.codecool.companyservice.service.ProjectServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private ProjectServiceCaller projectServiceCaller;

    @GetMapping("/all-project")
    public ProjectData[] getAllProject(){
        return projectServiceCaller.getAllProject();
    }

}
