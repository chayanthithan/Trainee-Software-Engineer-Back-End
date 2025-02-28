package com.example.Junit.testing.service;

import com.example.Junit.testing.dto.PatientDto;
import com.example.Junit.testing.entity.Patient;
import com.example.Junit.testing.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.sql.SQLDataException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;


    @Test
    void getAllPatientDetails() {

    }

    @Test
    void addPatientDetails() throws SQLDataException {

        Patient savedPatient = Patient.builder()
                .id(1L)
                .name("test")
                .age(10)
                .disease("test")
                .address("test")
                .build();

        Patient patient = Patient.builder()
                .name("sample")
                .age(10)
                .disease("test")
                .address("test")
                .build();

        PatientDto patientDto = PatientDto.builder()
                .name("sample")
                .age(10)
                .disease("test")
                .address("test")
                .build();

        when(patientRepository.findByName(patientDto.getName())).thenReturn(Collections.emptyList());
        when(patientRepository.save(patient)).thenReturn(savedPatient);
        ResponseEntity<Patient> patientResponse =  patientService.addPatientDetails(patientDto);
        assertNotNull(patientResponse);
    }
}