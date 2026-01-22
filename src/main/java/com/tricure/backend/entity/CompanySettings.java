package com.tricure.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "company_settings")
@Data
public class CompanySettings {

    @Id
    private Long id = 1L; // Singleton entity

    @Column(columnDefinition = "TEXT")
    private String missionStatement;

    @Column(columnDefinition = "TEXT")
    private String history;

    private String email;
    private String phone;
    private String address;

    private String facebookUrl;
    private String linkedinUrl;
    private String twitterUrl;
}
