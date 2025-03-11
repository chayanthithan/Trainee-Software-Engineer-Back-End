package com.example.management_department_service.service;

import com.example.management_department_service.api.dto.AcademicStaffDto;
import com.example.management_department_service.api.dto.AcademicStaffResponseDto;
import com.example.management_department_service.converter.AcademicStaffConvert;
import com.example.management_department_service.entity.AcademicStaff;
import com.example.management_department_service.repository.AcademicStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcademicStaffService {

    private final AcademicStaffRepository academicStaffRepository;
    private final AcademicStaffConvert academicStaffConvert;
    public Optional<List<AcademicStaff>> getAcademicStaffList() {
        return Optional.of(academicStaffRepository.findAll());
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
