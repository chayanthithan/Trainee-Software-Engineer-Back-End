package com.example.technology_department_service.service;

import com.example.technology_department_service.converter.NonAcademicStaffConverter;
import com.example.technology_department_service.dto.NonAcademicStaffDto;
import com.example.technology_department_service.dto.NonAcademicStaffResponseDto;
import com.example.technology_department_service.entity.NonAcademicStaff;
import com.example.technology_department_service.enums.Faculty;
import com.example.technology_department_service.enums.Gender;
import com.example.technology_department_service.enums.Job;
import com.example.technology_department_service.repository.NonAcademicStaffRepository;
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
class NonAcademicStaffServiceTest {
    @Mock
    private NonAcademicStaffRepository nonAcademicStaffRepository;

    @Mock
    private NonAcademicStaffConverter nonAcademicStaffConverter;

    @InjectMocks
    private NonAcademicStaffService nonAcademicStaffService;

    @Test
    void testAcademicStaffList_whenSuccess(){

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


        when(nonAcademicStaffRepository.findAll()).thenReturn(List.of(nonAcademicStaff));
        List<NonAcademicStaff> response = nonAcademicStaffService.getAcademicStaffList();

        assertEquals(response.get(0).getId(),"test-06");
    }
    @Test
    void testAcademicStaffList_whenFailure(){

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


        when(nonAcademicStaffRepository.findAll()).thenReturn(new ArrayList<>());
        List<NonAcademicStaff> response = nonAcademicStaffService.getAcademicStaffList();

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

        when(nonAcademicStaffRepository.findById(id)).thenReturn(Optional.of(nonAcademicStaff));
        Optional<NonAcademicStaff> response = nonAcademicStaffService.getAcademicStaffById(id);

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

        when(nonAcademicStaffRepository.findById(id)).thenReturn(Optional.empty());
        Optional<NonAcademicStaff> response = nonAcademicStaffService.getAcademicStaffById(id);

        assertTrue(response.isEmpty());
    }

    @Test
    void testSaveAcademicStaffDetails_whenSuccess(){
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
        when(nonAcademicStaffConverter.convert(nonAcademicStaffDto)).thenReturn(nonAcademicStaff);
        when(nonAcademicStaffRepository.save(any(NonAcademicStaff.class))).thenReturn(nonAcademicStaff);
        NonAcademicStaffResponseDto response = nonAcademicStaffService.saveAcademicStaffDetails(nonAcademicStaffDto);

        assertEquals(response.getId(),"test-06");
    }
    @Test
    void testSaveAcademicStaffDetails_whenSaveFailure(){
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
        when(nonAcademicStaffConverter.convert(nonAcademicStaffDto)).thenReturn(nonAcademicStaff);
        when(nonAcademicStaffRepository.save(any(NonAcademicStaff.class))).thenThrow(new RuntimeException("invalid data"));
        Exception ex = assertThrows(RuntimeException.class,() -> nonAcademicStaffService.saveAcademicStaffDetails(nonAcademicStaffDto));


        assertEquals(ex.getMessage(),"invalid data");
    }
    @Test
    void testSaveAcademicStaffDetails_whenConvertFailure(){
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
        when(nonAcademicStaffConverter.convert(nonAcademicStaffDto)).thenThrow(new RuntimeException("invalid data"));
        //when convert method throw error the save method does not execute
        //        when(nonAcademicStaffRepository.save(any(NonAcademicStaff.class))).thenThrow(new RuntimeException("invalid data"));
        Exception ex = assertThrows(RuntimeException.class,() -> nonAcademicStaffService.saveAcademicStaffDetails(nonAcademicStaffDto));


        assertEquals(ex.getMessage(),"invalid data");
    }
}