package com.example.technology_department_service.service;

import com.example.technology_department_service.converter.AcademicStaffConvert;
import com.example.technology_department_service.dto.AcademicStaffDto;
import com.example.technology_department_service.dto.AcademicStaffResponseDto;
import com.example.technology_department_service.entity.AcademicStaff;
import com.example.technology_department_service.repository.AcademicStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcademicStaffService {

    private final AcademicStaffRepository academicStaffRepository;
    private final AcademicStaffConvert academicStaffConvert;
    public List<AcademicStaff> getAcademicStaffList() {
        return academicStaffRepository.findAll();
    }

    public Optional<AcademicStaff> getAcademicStaffById(String id) {
        return academicStaffRepository.findById(id);
    }

    public AcademicStaffResponseDto saveAcademicStaffDetails(AcademicStaffDto academicStaffDto) {
        AcademicStaff academicStaff = academicStaffRepository.save(academicStaffConvert.convert(academicStaffDto));
        return AcademicStaffResponseDto.builder()
                .status("Successfully created")
                .id(academicStaff.getId())
                .build();
    }
}

