package com.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    private String cui;
    private String name;
    private String address;
    private String registrationNumber;
}
