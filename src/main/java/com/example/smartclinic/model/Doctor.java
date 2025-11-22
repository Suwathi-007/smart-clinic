package com.example.smartclinic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    private String specialty;

    /**
     * availableTimes stored as JSON or string of time slots.
     * Using String to map JSON column easily; can use @Convert for structured type.
     */
    @Column(name = "available_times", columnDefinition = "json")
    private String availableTimes;

    // getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getAvailableTimes() { return availableTimes; }
    public void setAvailableTimes(String availableTimes) { this.availableTimes = availableTimes; }
}
