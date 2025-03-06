package com.example.user_management_service.api.converter;

import com.example.user_management_service.dto.UserDto;
import com.example.user_management_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
public class UserConverter {
    public User convert(UserDto userDto){
        return User.builder()
                .userId(userDto.getUserId())
                .role(userDto.getRole())
                .name(userDto.getName())
                .build();

    }
}
