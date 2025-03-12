package com.example.management_department_service.api.controller;

import com.example.management_department_service.api.dto.AcademicDtoProjection;
import com.example.management_department_service.api.dto.AcademicStaffDto;
import com.example.management_department_service.api.dto.AcademicStaffResponseDto;
import com.example.management_department_service.entity.AcademicStaff;
import com.example.management_department_service.service.AcademicStaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academic-staff")
@RequiredArgsConstructor
public class AcademicStaffController {

    private final AcademicStaffService academicStaffService;
    @GetMapping()
    public List<AcademicStaff> getAllAcademicStaff(){
        return academicStaffService.getAcademicStaffList();
    }

    @GetMapping("/{id}")
    public Optional<AcademicStaff> getAcademicStaffById(@PathVariable String id){
        return academicStaffService.getAcademicStaffById(id);

    }
    @PostMapping()
    public AcademicStaffResponseDto addAcademicStaff(@Valid @RequestBody AcademicStaffDto academicStaffDto){
        return academicStaffService.saveAcademicStaffDetails(academicStaffDto);
    }
    @GetMapping("/find/{id}")
    public Optional<AcademicDtoProjection> findAcademicStaffById(@PathVariable String id){
        return academicStaffService.findAcademicStaffById(id);
    }

}
