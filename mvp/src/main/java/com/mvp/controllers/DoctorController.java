package com.mvp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mvp.services.DoctorService;
import com.mvp.models.Doctor;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/schedule")
    public ResponseEntity<?> schedule(@RequestBody Doctor doctor) {
        return doctorService.schedule(doctor);
    }

    @PostMapping("/appointments/{id}/accept")
    public ResponseEntity<?> acceptAppointment(@PathVariable Long id) {
        return doctorService.acceptAppointment(id);
    }

    @PostMapping("/appointments/{id}/decline")
    public ResponseEntity<?> declineAppointment(@PathVariable Long id) {
        return doctorService.declineAppointment(id);
    }
}
