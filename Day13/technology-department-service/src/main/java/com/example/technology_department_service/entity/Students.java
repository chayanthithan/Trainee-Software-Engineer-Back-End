package com.example.technology_department_service.entity;

import com.example.technology_department_service.enums.Course;
import com.example.technology_department_service.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Students {
    @Id
    private String regNum;
    private String fullName;
    private String Address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Course course;
    private Year accYear;


}
