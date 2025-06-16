package com.example.admin_service.conveter;

import com.example.admin_service.api.dto.AdminDto;
import com.example.admin_service.entity.Admin;

public class AdminConveter {
    public Admin convert(AdminDto adminDto){
        return Admin.builder()
                .phoneNo(adminDto.getPhoneNo())
                .address(adminDto.getAddress())
                .email(adminDto.getEmail())
                .name(adminDto.getName())
                .build();
    }
}
