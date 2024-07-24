package com.mvp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    private String email;
    private String cpf;
    private String password;
    // getters and setters
}
