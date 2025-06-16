package com.example.management_department_service.api.controller;

import com.example.management_department_service.api.dto.AcademicStaffDto;
import com.example.management_department_service.api.dto.AcademicStaffResponseDto;
import com.example.management_department_service.api.dto.NonAcademicStaffDto;
import com.example.management_department_service.api.dto.NonAcademicStaffResponseDto;
import com.example.management_department_service.entity.AcademicStaff;
import com.example.management_department_service.entity.NonAcademicStaff;
import com.example.management_department_service.service.AcademicStaffService;
import com.example.management_department_service.service.NonAcademicStaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/non-academic-staff")
@RequiredArgsConstructor
public class NonAcademicStaffController {

    private final NonAcademicStaffService nonAcademicStaffService;
    @GetMapping()
    public Optional<List<NonAcademicStaff>> getAllNonAcademicStaff(){
        return nonAcademicStaffService.getAcademicStaffList();
    }

    @GetMapping("/{id}")
    public Optional<NonAcademicStaff> getNonAcademicStaffById(@PathVariable String id){
        return nonAcademicStaffService.getAcademicStaffById(id);
    }

    @PostMapping()
    public NonAcademicStaffResponseDto addNonAcademicStaff(@Valid @RequestBody NonAcademicStaffDto nonAcademicStaffDto){
        return nonAcademicStaffService.saveAcademicStaffDetails(nonAcademicStaffDto);
    }
}
