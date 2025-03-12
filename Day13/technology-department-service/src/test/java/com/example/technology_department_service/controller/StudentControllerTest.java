package com.example.technology_department_service.controller;

import com.example.technology_department_service.dto.StudentDto;
import com.example.technology_department_service.dto.StudentResponseDto;
import com.example.technology_department_service.entity.Students;
import com.example.technology_department_service.enums.Course;
import com.example.technology_department_service.enums.Gender;
import com.example.technology_department_service.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void testAddStudent_whenSuccess(){
        StudentDto studentDto = StudentDto.builder()
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .accYear(Year.parse("2018"))  // or .accYear(Year.from(LocalDate.parse("2018-01-01"))
                .address("test")
                .nic("121231111V")
                .gender(Gender.MALE)
                .course(Course.INFORMATION_AND_COMMUNICATION_TECHNOLOGY)
                .email("kumarchayan@Gmail.com")
                .build();
        StudentResponseDto responseDto = StudentResponseDto.builder()
                .id("test-01")
                .status("Successfully created")
                .build();

        when(studentService.saveStudentDetails(studentDto)).thenReturn(responseDto);
        StudentResponseDto response = studentController.addStudent(studentDto);

        assertNotNull(response);
        assertEquals(response.getId(),"test-01");

    }
    @Test
    void testAddStudent_whenFailure(){
        StudentDto studentDto = StudentDto.builder()
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .accYear(Year.parse("2018"))  // or .accYear(Year.from(LocalDate.parse("2018-01-01"))
                .address("test")
                .nic("121231111V")
                .gender(Gender.MALE)
                .course(Course.INFORMATION_AND_COMMUNICATION_TECHNOLOGY)
                .email("kumarchayan@Gmail.com")
                .build();
        StudentResponseDto responseDto = StudentResponseDto.builder()
                .id("test-01")
                .status("Successfully created")
                .build();

        when(studentService.saveStudentDetails(studentDto)).thenThrow(new RuntimeException("invalid data"));
        Exception e = assertThrows(RuntimeException.class,() -> studentController.addStudent(studentDto));

        assertEquals(e.getMessage(),"invalid data");

    }

}