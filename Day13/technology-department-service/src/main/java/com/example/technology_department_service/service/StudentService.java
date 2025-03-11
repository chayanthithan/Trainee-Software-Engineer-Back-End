package com.example.technology_department_service.service;

import com.example.technology_department_service.converter.StudentConverter;
import com.example.technology_department_service.dto.StudentDto;
import com.example.technology_department_service.dto.StudentResponseDto;
import com.example.technology_department_service.entity.Students;
import com.example.technology_department_service.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;
    public StudentResponseDto saveStudentDetails(StudentDto studentDto) {
        Students students = studentRepository.save(studentConverter.convert(studentDto));
        return StudentResponseDto.builder()
                .status("Successfully saved")
                .id(students.getRegNum())
                .build();
    }
}

