package com.example.product_service.client;

import com.example.product_service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "serManagementService",url = "${user.management.name}")
public interface UserClient {
    @GetMapping("/user")
    public List<UserDto> getAllUser();

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable Long id);

    @PostMapping("/user")
    public UserDto addUSerDetails(@RequestBody UserDto supplierDto);

    @DeleteMapping("user/{id}")
    public String deleteUser(@PathVariable Long id);


}
