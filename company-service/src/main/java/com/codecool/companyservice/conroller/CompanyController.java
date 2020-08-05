package com.codecool.companyservice.conroller;

import com.codecool.companyservice.model.ProjectData;
import com.codecool.companyservice.service.ProjectServiceCaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class CompanyController {

    @Autowired
    private ProjectServiceCaller projectServiceCaller;

    @Autowired
    private Environment env;


    private void logInfo(){
        log.info("port: "+env.getProperty("server.port")+" called at: "+ LocalDateTime.now());
    }

    @GetMapping("/all-project")
    public ProjectData[] getAllProject(){
        logInfo();
        return projectServiceCaller.getAllProject();
    }

}
