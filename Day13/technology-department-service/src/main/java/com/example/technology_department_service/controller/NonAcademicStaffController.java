package com.example.technology_department_service.controller;

import com.example.technology_department_service.dto.NonAcademicStaffDto;
import com.example.technology_department_service.dto.NonAcademicStaffResponseDto;
import com.example.technology_department_service.entity.NonAcademicStaff;
import com.example.technology_department_service.service.NonAcademicStaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tech-non-academic-staff")
@RequiredArgsConstructor
public class NonAcademicStaffController {

    private final NonAcademicStaffService nonAcademicStaffService;
    @GetMapping()
    public List<NonAcademicStaff> getAllAcademicStaff(){
        return nonAcademicStaffService.getAcademicStaffList();
    }

    @GetMapping("/{id}")
    public Optional<NonAcademicStaff> getAcademicStaffById(@PathVariable String id){
        return nonAcademicStaffService.getAcademicStaffById(id);
    }

    @PostMapping()
    public NonAcademicStaffResponseDto addNonAcademicStaff(@Valid @RequestBody NonAcademicStaffDto nonAcademicStaffDto){
        return nonAcademicStaffService.saveAcademicStaffDetails(nonAcademicStaffDto);
    }
}
