package com.example.applied_science_department_service.converter;

import com.example.applied_science_department_service.api.dto.NonAcademicStaffDto;
import com.example.applied_science_department_service.entity.NonAcademicStaff;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class NonAcademicStaffConverter {
    public NonAcademicStaff convert(NonAcademicStaffDto nonAcademicStaffDto){

        String[] name = nonAcademicStaffDto.getFullName().split(" ");
        Random rand = new Random();
        int num = rand.nextInt(100);

        return NonAcademicStaff.builder()
                .id(name[name.length-1]+"-"+num)
                .job(nonAcademicStaffDto.getJob())
                .dob(nonAcademicStaffDto.getDob())
                .age(nonAcademicStaffDto.getAge())
                .Address(nonAcademicStaffDto.getAddress())
                .faculty(nonAcademicStaffDto.getFaculty())
                .fullName(nonAcademicStaffDto.getFullName())
                .gender(nonAcademicStaffDto.getGender())
                .build();
    }
}
