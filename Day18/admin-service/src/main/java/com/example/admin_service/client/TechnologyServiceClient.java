package com.example.admin_service.client;

import com.example.admin_service.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "technology-department-service",url = "${technology.service.url}")
public interface TechnologyServiceClient {

    //-------------------------------- Academic Staff ------------------------------------
    @GetMapping("/tech-academic-staff")
    public List<AcademicStaffDto> getAllAcademicStaff();
    @GetMapping("/tech-academic-staff/{id}")
    public Optional<AcademicStaffDto> getAcademicStaffById(@PathVariable String id);

    @PostMapping("/tech-academic-staff")
    public AcademicStaffResponseDto addAcademicStaff(@Valid @RequestBody AcademicStaffDto academicStaffDto);

    //-------------------------------- Non Academic Staff ------------------------------------

    @GetMapping("/tech-non-academic-staff")
    public List<NonAcademicStaffDto> getAllNonAcademicStaff();

    @GetMapping("/tech-non-academic-staff/{id}")
    public Optional<NonAcademicStaffDto> getNonAcademicStaffById(@PathVariable String id);

    @PostMapping("/tech-non-academic-staff")
    public AcademicStaffResponseDto addNonAcademicStaff(@Valid @RequestBody NonAcademicStaffDto nonAcademicStaffDto);

    //-------------------------------- Non Academic Staff ------------------------------------
    @PostMapping("/tech-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentDto studentDto);

    @GetMapping("/tech-student/count")
    public int getAppliedStudentCount();
}
