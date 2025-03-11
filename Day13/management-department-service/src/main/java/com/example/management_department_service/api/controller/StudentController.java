package com.example.management_department_service.api.controller;

import com.example.management_department_service.api.dto.StudentDto;
import com.example.management_department_service.api.dto.StudentResponseDto;
import com.example.management_department_service.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;
    @PostMapping()
    public StudentResponseDto addStudent(@Valid @RequestBody StudentDto studentDto){
        return studentService.saveStudentDetails(studentDto);
    }
}
