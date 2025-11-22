package com.example.smartclinic.repository;

import com.example.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);

    @Query("SELECT p FROM Patient p WHERE p.email = :identifier OR p.phone = :identifier")
    Optional<Patient> findByEmailOrPhone(String identifier);
}
