package com.example.technology_department_service.controller;

import com.example.technology_department_service.dto.AcademicStaffDto;
import com.example.technology_department_service.dto.AcademicStaffResponseDto;
import com.example.technology_department_service.dto.NonAcademicStaffDto;
import com.example.technology_department_service.dto.NonAcademicStaffResponseDto;
import com.example.technology_department_service.entity.AcademicStaff;
import com.example.technology_department_service.entity.NonAcademicStaff;
import com.example.technology_department_service.enums.Faculty;
import com.example.technology_department_service.enums.Gender;
import com.example.technology_department_service.enums.Job;
import com.example.technology_department_service.service.NonAcademicStaffService;
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
class NonAcademicStaffControllerTest {
    @Mock
    private NonAcademicStaffService nonAcademicStaffService;

    @InjectMocks
    private NonAcademicStaffController nonAcademicStaffController;

    @Test
    void testGetAllAcademicStaff_whenSuccess(){
        NonAcademicStaff nonAcademicStaff = NonAcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        when(nonAcademicStaffService.getAcademicStaffList()).thenReturn(List.of(nonAcademicStaff));
        List<NonAcademicStaff> response = nonAcademicStaffController.getAllNonAcademicStaff();

        assertEquals(response.get(0).getId(),"test-06");

    }

    @Test
    void testGetAllAcademicStaff_whenFailure(){
        NonAcademicStaff nonAcademicStaff = NonAcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        when(nonAcademicStaffService.getAcademicStaffList()).thenReturn(new ArrayList<>());
        List<NonAcademicStaff> response = nonAcademicStaffController.getAllNonAcademicStaff();

        assertTrue(response.isEmpty());

    }

    @Test
    void testGetAcademicStaffById_whenIdExist(){
        String id = "test-06";
        NonAcademicStaff nonAcademicStaff = NonAcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        when(nonAcademicStaffService.getAcademicStaffById(id)).thenReturn(Optional.of(nonAcademicStaff));
        Optional<NonAcademicStaff> response = nonAcademicStaffController.getNonAcademicStaffById(id);

        assertNotNull(response);
        assertEquals(response.get().getId(),"test-06");
    }
    @Test
    void testGetAcademicStaffById_whenIdNotExist(){
        String id = "test-06";
        NonAcademicStaff nonAcademicStaff = NonAcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        when(nonAcademicStaffService.getAcademicStaffById(id)).thenReturn(Optional.empty());
        Optional<NonAcademicStaff> response = nonAcademicStaffController.getNonAcademicStaffById(id);

        assertTrue(response.isEmpty(),"There is not record match with the id");
    }

    @Test
    void testAddNonAcademicStaff_whenSuccess(){
        NonAcademicStaffDto nonAcademicStaffDto = NonAcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        NonAcademicStaff nonAcademicStaff = NonAcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        NonAcademicStaffResponseDto nonAcademicStaffResponseDto = NonAcademicStaffResponseDto.builder()
                .id("test-06")
                .status("Successfully created")
                .build();

        when(nonAcademicStaffService.saveAcademicStaffDetails(nonAcademicStaffDto)).thenReturn(nonAcademicStaffResponseDto);
        NonAcademicStaffResponseDto response = nonAcademicStaffController.addNonAcademicStaff(nonAcademicStaffDto);

        assertNotNull(response);
        assertEquals(response.getId(),"test-06");
    }
    @Test
    void testAddNonAcademicStaff_whenFailure(){
        NonAcademicStaffDto nonAcademicStaffDto = NonAcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        NonAcademicStaff nonAcademicStaff = NonAcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        NonAcademicStaffResponseDto nonAcademicStaffResponseDto = NonAcademicStaffResponseDto.builder()
                .id("test-06")
                .status("Successfully created")
                .build();

        when(nonAcademicStaffService.saveAcademicStaffDetails(nonAcademicStaffDto)).thenThrow(new RuntimeException("invalid data"));
        Exception e = assertThrows(RuntimeException.class,() -> nonAcademicStaffController.addNonAcademicStaff(nonAcademicStaffDto));

        assertEquals(e.getMessage(),"invalid data");
        ;
    }
}