package com.example.applied_science_department_service.api.dto;

import com.example.applied_science_department_service.enums.Course;
import com.example.applied_science_department_service.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    @NotBlank(message = "Full Name should not be empty or null")
    private String fullName;
    @NotBlank(message = "address should not be empty or null")
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Max(value = 60,message = "age  should less than 60")
    @Min(value = 18,message = "age  should greater than 18")
    private int age;
    @Past(message = "date should be past date")
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Course course;
    @Max(value = 2025,message = "age  should less than 60")
    @Min(value = 2000,message = "age  should greater than 18")
    private int accYear;
    @Email(message = "email should be in the correct format")
    private String email;
    @Pattern(regexp = "^(?:\\d{9}[XV]|\\d{11})$",message = "nic should be ")
    private String nic;
}