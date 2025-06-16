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

@FeignClient(name = "management-department-service",url = "${management.service.url}")
public interface ManagementServiceClient {

//    ------------------------------- Academic -----------------------------
    @GetMapping("/academic-staff")
    public List<AcademicStaffDto> getAllAcademicStaff();

    @GetMapping("/academic-staff/{id}")
    public Optional<AcademicStaffDto> getAcademicStaffById(@PathVariable String id);
    @PostMapping("/academic-staff")
    public AcademicStaffResponseDto addAcademicStaff(@Valid @RequestBody AcademicStaffDto academicStaffDto);
    @GetMapping("academic-staff/find/{id}")
    public Optional<AcademicDtoProjection> findAcademicStaffById(@PathVariable String id);

//    ------------------------------ Non Academic ------------------------------

    @GetMapping("/non-academic-staff")
    public Optional<List<NonAcademicStaffDto>> getAllNonAcademicStaff();

    @GetMapping("/non-academic-staff/{id}")
    public Optional<NonAcademicStaffDto> getNonAcademicStaffById(@PathVariable String id);

    @PostMapping("/non-academic-staff")
    public AcademicStaffResponseDto addNonAcademicStaff(@Valid @RequestBody NonAcademicStaffDto nonAcademicStaffDto);

//    -----------------------------  Student  -------------------------------------

    @PostMapping("/management-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentDto studentDto);

    @GetMapping("/management-student")
    public List<StudentResponseDtoNew> getStudents();

    @GetMapping("/management-student/count")
    public int getAppliedStudentCount();
}
