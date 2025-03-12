package com.example.management_department_service.api.dto;

import com.example.management_department_service.enums.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDtoNew {
    private String regNum;
    private String fullName;
    private Course course;
}
