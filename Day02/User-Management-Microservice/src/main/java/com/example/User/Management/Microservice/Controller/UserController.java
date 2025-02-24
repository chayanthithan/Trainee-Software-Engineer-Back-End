package com.example.User.Management.Microservice.Controller;

import com.example.User.Management.Microservice.Entity.UserEntity;
import com.example.User.Management.Microservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping()
    public String getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping()
    public UserEntity addUser(@RequestBody UserEntity userEntity){
        return userService.addUser(userEntity);
    }
}
