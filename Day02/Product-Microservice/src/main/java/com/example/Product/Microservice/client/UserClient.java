package com.example.Product.Microservice.client;

import com.example.Product.Microservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userClient",url = "http://localhost:8083")
public interface UserClient {
    @GetMapping("/user")
    public String getAllUsers();

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable Long id);

}
