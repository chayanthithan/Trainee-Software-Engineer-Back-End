package com.example.student_service.service;

import com.example.student_service.dto.StudentDto;
import com.example.student_service.entity.Student;
import com.example.student_service.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    public Student addStudent(StudentDto studentDto) {
        Student student = Student.builder()
                .name(studentDto.getName())
                .regNum(studentDto.getRegNum())
                .degree(studentDto.getDegree())
                .build();
        return repository.save(student);
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("There is no records in the given id"));
    }

}
