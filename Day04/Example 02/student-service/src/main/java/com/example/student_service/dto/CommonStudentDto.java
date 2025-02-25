package com.example.student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonStudentDto {
//student
    private String regNum;
    private String name;
    private String degree;
//   course
    private String courseName;
//    faculty
    private String facultyName;
}
