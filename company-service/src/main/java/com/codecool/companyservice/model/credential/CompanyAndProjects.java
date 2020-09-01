package com.codecool.companyservice.model.credential;

import com.codecool.companyservice.model.Company;
import com.codecool.companyservice.model.ProjectData;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.UUID;


@Data
@Builder
public class CompanyAndProjects {
    private Company[] company;
    private Map<UUID,ProjectData[]> projectsForCompany;
}
