package com.codecool.companyservice.model.credential;

import com.codecool.companyservice.model.Company;
import com.codecool.companyservice.model.ProjectData;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CompanyAndProjects {
    private Company company;
    private ProjectData[] projectData;
}
