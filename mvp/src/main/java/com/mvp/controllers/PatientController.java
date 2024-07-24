package com.mvp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mvp.services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/doctors")
    public ResponseEntity<?> searchDoctors(@RequestParam(required = false) String specialty,
                                           @RequestParam(required = false) Double distance,
                                           @RequestParam(required = false) Integer rating) {
        return patientService.searchDoctors(specialty, distance, rating);
    }

    @PostMapping("/appointments")
    public ResponseEntity<?> scheduleAppointment(@RequestBody Appointment appointment) {
        return patientService.scheduleAppointment(appointment);
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<?> cancelAppointment(@PathVariable Long id, @RequestBody String reason) {
        return patientService.cancelAppointment(id, reason);
    }

    @PostMapping("/medical-records")
    public ResponseEntity<?> uploadMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return patientService.uploadMedicalRecord(medicalRecord);
    }

    @PostMapping("/medical-records/share")
    public ResponseEntity<?> shareMedicalRecord(@RequestParam Long recordId, @RequestParam Long doctorId, @RequestParam String duration) {
        return patientService.shareMedicalRecord(recordId, doctorId, duration);
    }
}
