package com.example.user_management_service.api.controller;

import com.example.user_management_service.dto.UserDto;
import com.example.user_management_service.entity.User;
import com.example.user_management_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<User> getAllUser(){
         return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);

    }

    @PostMapping()
    public User addUserDetails(@Valid @RequestBody UserDto userDto){
        return userService.saveUserDetails(userDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUserById(id);
    }


}
