package com.example.management_department_service.api.controller;

import com.example.management_department_service.api.dto.StudentDto;
import com.example.management_department_service.api.dto.StudentResponseDto;
import com.example.management_department_service.api.dto.StudentResponseDtoNew;
import com.example.management_department_service.entity.Students;
import com.example.management_department_service.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management-student")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;
    @PostMapping()
    public StudentResponseDto addStudent(@Valid @RequestBody StudentDto studentDto){
        return studentService.saveStudentDetails(studentDto);
    }

    @GetMapping()
    public List<StudentResponseDtoNew> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/count")
    public int getManagementStudentCount(){
        return studentService.getStudentCount();
    }

    @DeleteMapping()
    public String deleteManagementStudent(@RequestParam String regNum){
        return studentService.deleteManagementStudent(regNum);
    }

    @PutMapping()
    public Students updateStudentDetails(@RequestBody Students students){
        return studentService.updateExistingStudent(students);
    }
}
