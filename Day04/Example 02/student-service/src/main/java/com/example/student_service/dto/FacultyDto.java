package com.example.student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Long id;
    private String name;
    private int numOfDepartments;
    private int numOfStudents;
    private int numOfLecturers;
}
