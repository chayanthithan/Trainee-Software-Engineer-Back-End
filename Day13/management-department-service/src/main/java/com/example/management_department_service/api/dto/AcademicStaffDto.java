package com.example.management_department_service.api.dto;

import com.example.management_department_service.enums.Faculty;
import com.example.management_department_service.enums.Gender;
import com.example.management_department_service.enums.Job;
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
public class AcademicStaffDto {
    @NotBlank(message = "Full Name should not be empty or null")
    private String fullName;
    @NotBlank(message = "address should not be empty or null")
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
//    @Max(value = 60,message = "age  should less than 60")
//    @Min(value = 18,message = "age  should greater than 18")
    @Size(max = 60, min = 18,message = "it must be 18<age>60")
    private int age;
    @Past(message = "date should be past date")
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Job job;
    @Enumerated(EnumType.STRING)
    private Faculty faculty;
}
