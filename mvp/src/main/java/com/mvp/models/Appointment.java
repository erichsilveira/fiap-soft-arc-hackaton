package com.mvp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doctorCrm;
    private String patientEmail;
    private String date;
    private String time;
    private String status; // Scheduled, Accepted, Declined
    // getters and setters
}
