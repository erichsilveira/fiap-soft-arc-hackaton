package com.mvp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mvp.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {
}
