package com.ebusiness.userservice;

import com.ebusiness.userservice.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @GetMapping()
    public List<UserDto> getAllUsers(){
        UserDto userDto = new UserDto();
        userDto.setFirstName("test");

        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(userDto);
        return userDtos;
    }
}
