package com.example.faculty_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FacultyDto {
    private String name;
    private int numOfDepartments;
    private int numOfStudents;
    private int numOfLecturers;
}
