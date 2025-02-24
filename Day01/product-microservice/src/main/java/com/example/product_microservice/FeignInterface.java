package com.example.product_microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("home-microservice")
public interface FeignInterface {
    @GetMapping("/home")
    public String home();
}
