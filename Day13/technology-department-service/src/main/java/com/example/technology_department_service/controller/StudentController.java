package com.example.technology_department_service.controller;

import com.example.technology_department_service.dto.StudentDto;
import com.example.technology_department_service.dto.StudentResponseDto;
import com.example.technology_department_service.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tech-student")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;
    @PostMapping()
    public StudentResponseDto addStudent(@Valid @RequestBody StudentDto studentDto){
        return studentService.saveStudentDetails(studentDto);
    }
}
