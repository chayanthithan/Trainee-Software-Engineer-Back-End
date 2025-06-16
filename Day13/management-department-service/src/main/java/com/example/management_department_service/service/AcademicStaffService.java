package com.example.management_department_service.service;

import com.example.management_department_service.api.dto.AcademicDtoProjection;
import com.example.management_department_service.api.dto.AcademicStaffDto;
import com.example.management_department_service.api.dto.AcademicStaffResponseDto;
import com.example.management_department_service.constants.ApplicationConstants;
import com.example.management_department_service.converter.AcademicStaffConvert;
import com.example.management_department_service.entity.AcademicStaff;
import com.example.management_department_service.exception.ServiceException;
import com.example.management_department_service.repository.AcademicStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    public Optional<AcademicDtoProjection> findAcademicStaffById(String id) {
        return academicStaffRepository.findAcademicStaffById(id);
    }

    public String deleteAcademicStaffById(String id) {
        Optional<AcademicStaff> academicStaff = academicStaffRepository.findById(id);
        if (academicStaff.isPresent()){
            academicStaffRepository.deleteById(id);
            return "Successfully deleted!";
        }else{
            throw new ServiceException(ApplicationConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST,"BAD_REQUEST");
        }
    }
}
