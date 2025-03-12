package com.example.management_department_service.service;

import com.example.management_department_service.api.dto.AcademicStaffDto;
import com.example.management_department_service.api.dto.AcademicStaffResponseDto;
import com.example.management_department_service.converter.AcademicStaffConvert;
import com.example.management_department_service.entity.AcademicStaff;
import com.example.management_department_service.enums.Faculty;
import com.example.management_department_service.enums.Gender;
import com.example.management_department_service.enums.Job;
import com.example.management_department_service.repository.AcademicStaffRepository;
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
class AcademicStaffServiceTest {

    @Mock
    private AcademicStaffRepository academicStaffRepository;

    @Mock
    private AcademicStaffConvert academicStaffConvert;
    @InjectMocks
    private AcademicStaffService academicStaffService;

    @Test
    void testGetAcademicStaffList_whenReturnSuccess(){
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.PROJECT_MANAGEMENT)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        when(academicStaffRepository.findAll()).thenReturn(List.of(academicStaff));
        List<AcademicStaff> response = academicStaffService.getAcademicStaffList();

        assertNotNull(response);
        assertEquals(response.get(0).getId(),"test-06");
    }
    @Test
    void testGetAcademicStaffList_whenReturnEmpty(){

        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.PROJECT_MANAGEMENT)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        when(academicStaffRepository.findAll()).thenReturn(new ArrayList<>());
        List<AcademicStaff> response = academicStaffService.getAcademicStaffList();

        assertTrue(response.isEmpty());
    }

    @Test
    void testGetAcademicStaffById_whenSuccess(){
        String id = "test-06";
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.PROJECT_MANAGEMENT)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        when(academicStaffRepository.findById(id)).thenReturn(Optional.of(academicStaff));
        Optional<AcademicStaff> response = academicStaffService.getAcademicStaffById(id);

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
                .faculty(Faculty.PROJECT_MANAGEMENT)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        when(academicStaffRepository.findById(id)).thenReturn(Optional.empty());
        Optional<AcademicStaff> response = academicStaffService.getAcademicStaffById(id);

        assertTrue(response.isEmpty());
    }

    @Test
    void testSaveAcademicStaffDetails_whenSuccess(){
        AcademicStaffDto academicStaffDto = AcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.PROJECT_MANAGEMENT)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName(academicStaffDto.getFullName())
                .Address(academicStaffDto.getAddress())
                .faculty(academicStaffDto.getFaculty())
                .gender(academicStaffDto.getGender())
                .age(academicStaffDto.getAge())
                .dob(academicStaffDto.getDob())
                .job(academicStaffDto.getJob())
                .build();
        AcademicStaffResponseDto academicResponseDto = AcademicStaffResponseDto.builder()
                .id("test-06")
                .status("Successfully created")
                .build();
        when(academicStaffRepository.save(academicStaff)).thenReturn(academicStaff);
        when(academicStaffConvert.convert(academicStaffDto)).thenReturn(academicStaff);

        AcademicStaffResponseDto response = academicStaffService.saveAcademicStaffDetails(academicStaffDto);
        assertNotNull(response);
        assertEquals(response.getId(),"test-06");

    }
    @Test
    void testSaveAcademicStaffDetails_whenFailure(){
        AcademicStaffDto academicStaffDto = AcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.PROJECT_MANAGEMENT)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-06")
                .fullName(academicStaffDto.getFullName())
                .Address(academicStaffDto.getAddress())
                .faculty(academicStaffDto.getFaculty())
                .gender(academicStaffDto.getGender())
                .age(academicStaffDto.getAge())
                .dob(academicStaffDto.getDob())
                .job(academicStaffDto.getJob())
                .build();
        AcademicStaffResponseDto academicResponseDto = AcademicStaffResponseDto.builder()
                .id("test-06")
                .status("Successfully created")
                .build();
        when(academicStaffRepository.save(academicStaff)).thenThrow(new RuntimeException("invalid data"));
        when(academicStaffConvert.convert(academicStaffDto)).thenReturn(academicStaff);

        Exception e = assertThrows(RuntimeException.class,() -> academicStaffService.saveAcademicStaffDetails(academicStaffDto));
        assertEquals(e.getMessage(),"invalid data");

    }
}