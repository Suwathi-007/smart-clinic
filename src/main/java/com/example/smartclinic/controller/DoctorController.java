package com.example.smartclinic.controller;

import com.example.smartclinic.service.DoctorService;
import com.example.smartclinic.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // GET /api/doctors/{id}/availability?date=2025-11-22
    @GetMapping("/{id}/availability")
    public ResponseEntity<?> getAvailability(
        @PathVariable Long id,
        @RequestParam String date,
        @RequestHeader("Authorization") String token // validate token header
    ) {
        // token validation (simple example - delegate to TokenService in real app)
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Invalid or missing token");
        }

        LocalDate localDate = LocalDate.parse(date);
        try {
            return ResponseEntity.ok(doctorService.getAvailableTimeSlots(id, localDate));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
        }
    }
}
