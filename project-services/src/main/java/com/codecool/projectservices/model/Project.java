package com.codecool.projectservices.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Project {
    @GeneratedValue
    @Id
    private UUID id;

    @Column
    private String name;

    @ElementCollection
    private List<UUID> companyIds;
}
