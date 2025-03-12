package com.example.technology_department_service.service;

import com.example.technology_department_service.converter.StudentConverter;
import com.example.technology_department_service.dto.StudentDto;
import com.example.technology_department_service.dto.StudentResponseDto;
import com.example.technology_department_service.entity.Students;
import com.example.technology_department_service.enums.Course;
import com.example.technology_department_service.enums.Gender;
import com.example.technology_department_service.repository.StudentRepository;
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
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentConverter studentConverter;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testSaveStudentDetails_whenSuccess(){
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
        Students students= Students.builder()
                .regNum("2018/PM/01")
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .accYear(Year.parse("2018"))  // or .accYear(Year.from(LocalDate.parse("2018-01-01"))
                .Address("test")
                .nic("121231111V")
                .gender(Gender.MALE)
                .course(Course.INFORMATION_AND_COMMUNICATION_TECHNOLOGY)
                .email("kumarchayan@Gmail.com")
                .build();
        StudentResponseDto responseDto = StudentResponseDto.builder()
                .id("2018/PM/01")
                .status("Successfully created")
                .build();

        when(studentConverter.convert(studentDto)).thenReturn(students);
        when(studentRepository.save(any(Students.class))).thenReturn(students);
        StudentResponseDto response = studentService.saveStudentDetails(studentDto);

        assertEquals(response.getId(),"2018/PM/01");
    }


    @Test
    void testSaveStudentDetails_whenConvertFailure(){
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
        Students students= Students.builder()
                .regNum("2018/PM/01")
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .accYear(Year.parse("2018"))  // or .accYear(Year.from(LocalDate.parse("2018-01-01"))
                .Address("test")
                .nic("121231111V")
                .gender(Gender.MALE)
                .course(Course.INFORMATION_AND_COMMUNICATION_TECHNOLOGY)
                .email("kumarchayan@Gmail.com")
                .build();
        StudentResponseDto responseDto = StudentResponseDto.builder()
                .id("2018/PM/01")
                .status("Successfully created")
                .build();

        when(studentConverter.convert(studentDto)).thenThrow(new RuntimeException("invalid data"));
//        when(studentRepository.save(any(Students.class))).thenReturn(students);
        Exception ex = assertThrows(RuntimeException.class,() -> studentService.saveStudentDetails(studentDto));
        assertEquals(ex.getMessage(),"invalid data");
    }


@Test
    void testSaveStudentDetails_whenSaveFailure(){
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
        Students students= Students.builder()
                .regNum("2018/PM/01")
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .accYear(Year.parse("2018"))  // or .accYear(Year.from(LocalDate.parse("2018-01-01"))
                .Address("test")
                .nic("121231111V")
                .gender(Gender.MALE)
                .course(Course.INFORMATION_AND_COMMUNICATION_TECHNOLOGY)
                .email("kumarchayan@Gmail.com")
                .build();
        StudentResponseDto responseDto = StudentResponseDto.builder()
                .id("2018/PM/01")
                .status("Successfully created")
                .build();

        when(studentConverter.convert(studentDto)).thenReturn(students);
        when(studentRepository.save(any(Students.class))).thenThrow(new RuntimeException("invalid data"));
        Exception ex = assertThrows(RuntimeException.class,() -> studentService.saveStudentDetails(studentDto));
        assertEquals(ex.getMessage(),"invalid data");
    }

}