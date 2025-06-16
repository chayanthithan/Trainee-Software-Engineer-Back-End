package com.example.admin_service.api.dto;

import com.example.admin_service.enums.Faculty;
import com.example.admin_service.enums.Gender;
import com.example.admin_service.enums.Job;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
