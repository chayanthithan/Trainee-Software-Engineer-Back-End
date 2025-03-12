package com.example.technology_department_service.controller;

import com.example.technology_department_service.dto.AcademicStaffDto;
import com.example.technology_department_service.dto.AcademicStaffResponseDto;
import com.example.technology_department_service.entity.AcademicStaff;
import com.example.technology_department_service.enums.Faculty;
import com.example.technology_department_service.enums.Gender;
import com.example.technology_department_service.enums.Job;
import com.example.technology_department_service.service.AcademicStaffService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class AcademicStaffControllerTest {
    @Mock
    private AcademicStaffService academicStaffService;

    @InjectMocks
    private AcademicStaffController academicStaffController;

    @Test
    void testGetAllAcademicStaff_whenSuccess(){
        AcademicStaffDto academicStaffDto = AcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaffResponseDto academicResponseDto = AcademicStaffResponseDto.builder()
                .id("test-06")
                .status("Successfully created")
                .build();
        when(academicStaffService.getAcademicStaffList()).thenReturn(List.of(academicStaff));
        List<AcademicStaff> response = academicStaffController.getAllAcademicStaff();

        assertNotNull(response);
        assertEquals(response.get(0).getId(),"test-06");
    }
    @Test
    void testGetAllAcademicStaff_whenFailure(){
        AcademicStaffDto academicStaffDto = AcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaffResponseDto academicResponseDto = AcademicStaffResponseDto.builder()
                .id("test-06")
                .status("Successfully created")
                .build();
        when(academicStaffService.getAcademicStaffList()).thenReturn(new ArrayList<>());
        List<AcademicStaff> response = academicStaffController.getAllAcademicStaff();

        assertTrue(response.isEmpty());
    }

    @Test
    void testGetAcademicStaffById_whenIdExist(){
        String id = "test-06";
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        when(academicStaffService.getAcademicStaffById(id)).thenReturn(Optional.of(academicStaff));
        Optional<AcademicStaff> response = academicStaffController.getAcademicStaffById(id);

        assertNotNull(response);
        assertEquals(response.get().getId(),"test-06");
    }
    @Test
    void testGetAcademicStaffById_whenIdNotExist(){
        String id = "test-06";
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        when(academicStaffService.getAcademicStaffById(id)).thenReturn(Optional.of(academicStaff));
        Optional<AcademicStaff> response = academicStaffController.getAcademicStaffById(id);

        assertNotNull(response);
        assertEquals(response.get().getId(),"test-06");
    }

    @Test
    void testAddAcademicStaff_whenSuccess(){
        AcademicStaffDto academicStaffDto = AcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaffResponseDto academicResponseDto = AcademicStaffResponseDto.builder()
                .id("test-06")
                .status("Successfully created")
                .build();

        when(academicStaffService.saveAcademicStaffDetails(academicStaffDto)).thenReturn(academicResponseDto);
        AcademicStaffResponseDto response = academicStaffController.addAcademicStaff(academicStaffDto);

        assertEquals(response.getId(),"test-06");

    }
    @Test
    void testAddAcademicStaff_whenFailure(){
        AcademicStaffDto academicStaffDto = AcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaffResponseDto academicResponseDto = AcademicStaffResponseDto.builder()
                .id("test-06")
                .status("Successfully created")
                .build();

        when(academicStaffService.saveAcademicStaffDetails(academicStaffDto)).thenThrow(new RuntimeException("invalid data"));
        Exception e = assertThrows(RuntimeException.class,() -> academicStaffController.addAcademicStaff(academicStaffDto));

        assertEquals(e.getMessage(),"invalid data");

    }
}