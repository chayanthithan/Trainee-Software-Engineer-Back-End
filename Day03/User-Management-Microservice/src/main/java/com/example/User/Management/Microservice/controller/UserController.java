package com.example.User.Management.Microservice.controller;

import com.example.User.Management.Microservice.entity.User;
import com.example.User.Management.Microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
//get all users
    @GetMapping()
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
//get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping()
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }


}
