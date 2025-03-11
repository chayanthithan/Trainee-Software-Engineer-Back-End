package com.example.technology_department_service.converter;

import com.example.technology_department_service.dto.AcademicStaffDto;
import com.example.technology_department_service.entity.AcademicStaff;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class AcademicStaffConvert {
    public AcademicStaff convert(AcademicStaffDto academicStaffDto){

        String[] name = academicStaffDto.getFullName().split(" ");
        Random rand = new Random();
        int num = rand.nextInt(100);

        return AcademicStaff.builder()
                .id(name[name.length-1]+"-"+num)
                .job(academicStaffDto.getJob())
                .dob(academicStaffDto.getDob())
                .age(academicStaffDto.getAge())
                .Address(academicStaffDto.getAddress())
                .faculty(academicStaffDto.getFaculty())
                .fullName(academicStaffDto.getFullName())
                .gender(academicStaffDto.getGender())
                .build();
    }
}