package com.mvp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mvp.models.Doctor;
import com.mvp.models.Patient;
import com.mvp.repositories.DoctorRepository;
import com.mvp.repositories.PatientRepository;
import com.mvp.utils.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public ResponseEntity<?> doctorLogin(Doctor doctor) {
        Doctor foundDoctor = doctorRepository.findById(doctor.getCrm()).orElse(null);
        if (foundDoctor != null && foundDoctor.getPassword().equals(doctor.getPassword())) {
            String token = jwtUtil.generateToken(foundDoctor.getCrm());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    public ResponseEntity<?> patientLogin(Patient patient) {
        Patient foundPatient = patientRepository.findById(patient.getEmail()).orElse(null);
        if (foundPatient != null && foundPatient.getPassword().equals(patient.getPassword())) {
            String token = jwtUtil.generateToken(foundPatient.getEmail());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }
}
