package com.example.applied_science_department_service.api.controller;

import com.example.applied_science_department_service.api.dto.StudentDto;
import com.example.applied_science_department_service.api.dto.StudentResponseDto;
import com.example.applied_science_department_service.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applied-student")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;
    @PostMapping()
    public StudentResponseDto addStudent(@Valid @RequestBody StudentDto studentDto){
        return studentService.saveStudentDetails(studentDto);
    }

    @GetMapping("/count")
    public int getAppliedStudentCount(){
        return studentService.getStudentCount();
    }
}
