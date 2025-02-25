package com.example.student_service.service;

import com.example.student_service.client.CourseClient;
import com.example.student_service.client.FacultyClient;
import com.example.student_service.dto.CommonStudentDto;
import com.example.student_service.dto.CourseDto;
import com.example.student_service.dto.FacultyDto;
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
    private final CourseClient courseClient;
    private final FacultyClient facultyClient;
    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    public Student addStudent(CommonStudentDto commonStudentDto) {

        FacultyDto facultyDto = facultyClient.getFacultyByName(commonStudentDto.getFacultyName());
        CourseDto courseDto  = courseClient.getCourseByName(commonStudentDto.getCourseName());
        if (facultyDto == null ){
            throw new NullPointerException("there is no faculty in the given name. please create it!!");
        }

        if(courseDto == null){
            throw new NullPointerException("there is no faculty in the given name. please create it!!");
        }


        Student student = Student.builder()
                .name(commonStudentDto.getName())
                .regNum(commonStudentDto.getRegNum())
                .degree(commonStudentDto.getDegree())
                .build();
        return repository.save(student);
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("There is no records in the given id"));
    }

}
