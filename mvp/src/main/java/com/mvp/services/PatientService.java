package com.mvp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mvp.models.Appointment;
import com.mvp.models.MedicalRecord;
import com.mvp.repositories.AppointmentRepository;
import com.mvp.repositories.DoctorRepository;
import com.mvp.repositories.MedicalRecordRepository;
import com.mvp.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public ResponseEntity<?> searchDoctors(String specialty, Double distance, Integer rating) {
        // Implement search logic based on filters
        return ResponseEntity.ok(doctorRepository.findAll());
    }

    public ResponseEntity<?> scheduleAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return ResponseEntity.ok("Appointment scheduled");
    }

    public ResponseEntity<?> cancelAppointment(Long id, String reason) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment != null) {
            appointmentRepository.deleteById(id);
            return ResponseEntity.ok("Appointment canceled");
        }
        return ResponseEntity.status(404).body("Appointment not found");
    }

    public ResponseEntity<?> uploadMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
        return ResponseEntity.ok("Medical record uploaded");
    }

    public ResponseEntity<?> shareMedicalRecord(Long recordId, Long doctorId, String duration) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(recordId).orElse(null);
        if (medicalRecord != null) {
            medicalRecord.setSharedWith(doctorId.toString());
            medicalRecord.setDuration(duration);
            medicalRecordRepository.save(medicalRecord);
            return ResponseEntity.ok("Medical record shared");
        }
        return ResponseEntity.status(404).body("Medical record not found");
    }
}
