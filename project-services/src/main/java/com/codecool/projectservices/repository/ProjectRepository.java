package com.codecool.projectservices.repository;

import com.codecool.projectservices.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

    List<Project> findProjectsByCompanyIdsContaining(UUID companyId);

    Project getProjectById(UUID projectId);
}
