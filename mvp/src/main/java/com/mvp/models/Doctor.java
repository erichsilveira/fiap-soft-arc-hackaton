package com.mvp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    private String crm;
    private String name;
    private String password;
    // getters and setters
}
