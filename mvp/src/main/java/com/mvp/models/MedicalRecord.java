package com.mvp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientEmail;
    private String fileName;
    private String fileContent; // Base64 encoded content
    private String sharedWith;
    private String duration; // Duration for sharing
    // getters and setters
}
