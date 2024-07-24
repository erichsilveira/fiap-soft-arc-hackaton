package com.mvp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mvp.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
