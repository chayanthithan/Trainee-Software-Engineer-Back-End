package com.example.student_service.controller;

import com.example.student_service.dto.CommonStudentDto;
import com.example.student_service.dto.StudentDto;
import com.example.student_service.entity.Student;
import com.example.student_service.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping()
    public List<Student> getAllStudent(){
        return service.getAllStudent();
    }

    @PostMapping()
    public Student addStudent(@RequestBody CommonStudentDto commonStudentDto){
        return service.addStudent(commonStudentDto);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return service.getStudentById(id);
    }
}
