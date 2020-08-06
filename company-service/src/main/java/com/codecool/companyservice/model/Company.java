package com.codecool.companyservice.model;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @GeneratedValue
    @Id
    private UUID id;

    private String name;

    @ElementCollection
    private List<UUID> employeeIds = new ArrayList<>();

}
