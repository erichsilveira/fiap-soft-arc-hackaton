package com.mvp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mvp.models.Doctor;
import com.mvp.models.Appointment;
import com.mvp.repositories.DoctorRepository;
import com.mvp.repositories.AppointmentRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public ResponseEntity<?> schedule(Doctor doctor) {
        doctorRepository.save(doctor);
        return ResponseEntity.ok("Schedule updated");
    }

    public ResponseEntity<?> acceptAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment != null) {
            appointment.setStatus("Accepted");
            appointmentRepository.save(appointment);
            return ResponseEntity.ok("Appointment accepted");
        }
        return ResponseEntity.status(404).body("Appointment not found");
    }

    public ResponseEntity<?> declineAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment != null) {
            appointment.setStatus("Declined");
            appointmentRepository.save(appointment);
            return ResponseEntity.ok("Appointment declined");
        }
        return ResponseEntity.status(404).body("Appointment not found");
    }
}
