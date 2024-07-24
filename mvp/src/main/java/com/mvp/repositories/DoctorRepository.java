package com.mvp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mvp.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
}
