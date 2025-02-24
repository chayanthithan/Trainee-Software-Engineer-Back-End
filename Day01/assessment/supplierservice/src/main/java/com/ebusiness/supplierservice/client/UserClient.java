package com.ebusiness.supplierservice.client;

import com.ebusiness.supplierservice.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "userClient", url="http://localhost:8081")
public interface UserClient {
    @GetMapping("/users")
    public List<UserDto> getAllUsers();
}
