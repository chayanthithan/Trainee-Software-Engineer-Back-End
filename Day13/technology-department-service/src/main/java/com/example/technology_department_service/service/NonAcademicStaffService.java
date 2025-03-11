package com.example.technology_department_service.service;

import com.example.technology_department_service.converter.NonAcademicStaffConverter;
import com.example.technology_department_service.dto.NonAcademicStaffDto;
import com.example.technology_department_service.dto.NonAcademicStaffResponseDto;
import com.example.technology_department_service.entity.NonAcademicStaff;
import com.example.technology_department_service.repository.NonAcademicStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NonAcademicStaffService {

    private final NonAcademicStaffRepository nonAcademicStaffRepository;
    private final NonAcademicStaffConverter nonAcademicStaffConvert;
    public Optional<List<NonAcademicStaff>> getAcademicStaffList() {
        return Optional.of(nonAcademicStaffRepository.findAll());
    }

    public Optional<NonAcademicStaff> getAcademicStaffById(String id) {
        return nonAcademicStaffRepository.findById(id);
    }

    public NonAcademicStaffResponseDto saveAcademicStaffDetails(NonAcademicStaffDto nonAcademicStaffDto) {
        NonAcademicStaff academicStaff = nonAcademicStaffRepository.save(nonAcademicStaffConvert.convert(nonAcademicStaffDto));
        return NonAcademicStaffResponseDto.builder()
                .status("Successfully created")
                .id(academicStaff.getId())
                .build();
    }
}
