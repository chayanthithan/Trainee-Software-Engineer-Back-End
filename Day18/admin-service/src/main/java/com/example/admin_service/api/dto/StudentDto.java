package com.example.admin_service.api.dto;

import com.example.admin_service.enums.Course;
import com.example.admin_service.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class StudentDto {

    private String fullName;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Course course;
    private int accYear;
    private String email;
    private String nic;

}
