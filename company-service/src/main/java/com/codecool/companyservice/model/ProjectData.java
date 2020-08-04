package com.codecool.companyservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ProjectData {

    private UUID id;
    private String name;
}
