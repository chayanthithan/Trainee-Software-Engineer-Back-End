package com.example.technology_department_service.service;

import com.example.technology_department_service.converter.AcademicStaffConvert;
import com.example.technology_department_service.dto.AcademicStaffDto;
import com.example.technology_department_service.dto.AcademicStaffResponseDto;
import com.example.technology_department_service.entity.AcademicStaff;
import com.example.technology_department_service.enums.Faculty;
import com.example.technology_department_service.enums.Gender;
import com.example.technology_department_service.enums.Job;
import com.example.technology_department_service.repository.AcademicStaffRepository;
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
    void testGetAcademicStaffList_whenSuccess(){
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
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
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
    void testGetAcademicStaffById_whenIdExist(){
        String id = "test-01";
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-01")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        when(academicStaffRepository.findById(id)).thenReturn(Optional.of(academicStaff));
        Optional<AcademicStaff> response = academicStaffService.getAcademicStaffById(id);

        assertNotNull(response);
        assertEquals(response.get().getId(),"test-01");
    }
    @Test
    void testGetAcademicStaffById_whenIdNotExist(){
        String id = "test-01";
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-01")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
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
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-01")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        AcademicStaffDto dto = AcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaffResponseDto responseDto = AcademicStaffResponseDto.builder()
                .id("test-01")
                .status("Successfully saved")
                .build();

        when(academicStaffRepository.save(any(AcademicStaff.class))).thenReturn(academicStaff);
        when(academicStaffConvert.convert(dto)).thenReturn(academicStaff);
        AcademicStaffResponseDto response = academicStaffService.saveAcademicStaffDetails(dto);

        assertEquals(response.getId(),"test-01");
    }
    @Test
    void testSaveAcademicStaffDetails_whenFailure(){
        AcademicStaff academicStaff = AcademicStaff.builder()
                .id("test-01")
                .fullName("test test")
                .Address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();
        AcademicStaffDto dto = AcademicStaffDto.builder()
                .fullName("test test")
                .address("test")
                .faculty(Faculty.TECHNOLOGICAL_STUDIES)
                .gender(Gender.MALE)
                .age(56)
                .dob(LocalDate.parse("1999-12-20"))
                .job(Job.ASSISTANT_LECTURER)
                .build();

        AcademicStaffResponseDto responseDto = AcademicStaffResponseDto.builder()
                .id("test-01")
                .status("Successfully saved")
                .build();

        when(academicStaffConvert.convert(dto)).thenReturn(academicStaff);
        when(academicStaffRepository.save(any(AcademicStaff.class))).thenThrow(new RuntimeException("invalid data"));
        Exception ex = assertThrows(RuntimeException.class,() -> academicStaffService.saveAcademicStaffDetails(dto));

        assertEquals(ex.getMessage(),"invalid data");
    }
}