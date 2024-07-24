package com.mvp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mvp.services.AuthService;
import com.mvp.models.Doctor;
import com.mvp.models.Patient;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login/doctor")
    public ResponseEntity<?> doctorLogin(@RequestBody Doctor doctor) {
        return authService.doctorLogin(doctor);
    }

    @PostMapping("/login/patient")
    public ResponseEntity<?> patientLogin(@RequestBody Patient patient) {
        return authService.patientLogin(patient);
    }
}
