package com.example.Junit.testing.service;

import com.example.Junit.testing.dto.PatientDto;
import com.example.Junit.testing.entity.Patient;
import com.example.Junit.testing.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.ast.tree.insert.ConflictClause;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.sql.SQLDataException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public ResponseEntity<List<Patient>> getAllPatientDetails() {
        List<Patient> patientList = patientRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(patientList);
    }

    public ResponseEntity<Patient> addPatientDetails(PatientDto patientDto) {

        Patient patient = Patient.builder()
                .name(patientDto.getName())
                .age(patientDto.getAge())
                .disease(patientDto.getDisease())
                .address(patientDto.getAddress())
                .build();

        List<Patient> patientList = patientRepository.findByName(patientDto.getName());

        for (Patient patientObj:patientList) {
            if (patientDto.getName().equals(patientObj.getName())
                    && patientDto.getDisease().equals(patientObj.getDisease())
                    && patientDto.getAddress().equals(patientObj.getAddress())
                    && patientDto.getAge() == (patientObj.getAge())) {

                throw new RuntimeException("already Exist");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(patientRepository.save(patient));
    }
}
