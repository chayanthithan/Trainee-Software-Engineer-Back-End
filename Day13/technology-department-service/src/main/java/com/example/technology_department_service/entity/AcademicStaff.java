package com.example.technology_department_service.entity;

import com.example.technology_department_service.enums.Faculty;
import com.example.technology_department_service.enums.Gender;
import com.example.technology_department_service.enums.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AcademicStaff {
    @Id
    private String id;
    private String fullName;
    private String Address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Job job;
    @Enumerated(EnumType.STRING)
    private Faculty faculty;
}
