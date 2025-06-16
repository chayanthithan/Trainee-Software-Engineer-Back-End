package com.example.admin_service.client;

import com.example.admin_service.api.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "applied-science-department-service",url = "${applied.service.url}")
public interface AppliedServiceClient {

//-------------------------- Academic Staff -----------------------------------
    @GetMapping("/applied-academic-staff")
    public Optional<List<AcademicStaffDto>> getAllAcademicStaff();

    @GetMapping("/applied-academic-staff/{id}")
    public Optional<AcademicStaffDto> getAcademicStaffById(@PathVariable String id);

    @PostMapping("/applied-academic-staff")
    public AcademicStaffResponseDto addAcademicStaff(@Valid @RequestBody AcademicStaffDto academicStaffDto);

//--------------------------  Non Academic Staff -----------------------------------

    @GetMapping("/applied-non-academic-staff")
    public Optional<List<NonAcademicStaffDto>> getAllNonAcademicStaff();

    @GetMapping("/applied-non-academic-staff/{id}")
    public Optional<NonAcademicStaffDto> getNonAcademicStaffById(@PathVariable String id);

    @PostMapping("/applied-non-academic-staff")
    public AcademicStaffResponseDto addNonAcademicStaff(@Valid @RequestBody NonAcademicStaffDto nonAcademicStaffDto);

    //---------------------------- student -----------------------------
    @PostMapping("/applied-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentDto studentDto);

    @GetMapping("/applied-student/count")
    public int getAppliedStudentCount();
}
