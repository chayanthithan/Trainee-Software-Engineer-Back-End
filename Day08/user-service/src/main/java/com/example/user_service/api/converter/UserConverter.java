package com.example.user_service.api.converter;

import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.User;

public class UserConverter {

    public User convertUserDtoToUser(UserDto userDto){
        return User.builder()
                .nic(userDto.getNic())
                .name(userDto.getName())
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .phoneNo(userDto.getPhoneNo())
                .build();
    }

}
