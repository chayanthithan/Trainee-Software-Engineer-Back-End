package com.example.Product.Microservice.client;

import com.example.Product.Microservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "UserClient",url="${client.service.url}")
public interface UserClient {
    @GetMapping("/user")
    public List<UserDto> getAllUser();

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable Long id);

    @PostMapping("/user")
    public UserDto addUser(@RequestBody UserDto user);

}
