package com.example.faculty_service.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Faculty {
    private Long id;
    private String name;
    private int numOfDepartments;
    private int numOfStudents;
    private int numOfLecturers;

}
