package com.example.Junit.testing.controller;

import com.example.Junit.testing.dto.PatientDto;
import com.example.Junit.testing.entity.Patient;
import com.example.Junit.testing.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;
import java.util.List;

@RequestMapping("/patient")
@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping()
    public ResponseEntity<List<Patient>> getAllPatientDetails(){
        return patientService.getAllPatientDetails();

    }
    @PostMapping()
    public ResponseEntity<?> addPatientDetails(@RequestBody PatientDto patientDto) throws SQLDataException {
        return patientService.addPatientDetails(patientDto);
    }


}
