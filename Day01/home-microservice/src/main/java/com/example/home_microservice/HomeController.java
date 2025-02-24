package com.example.home_microservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home-service")
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "this is the home page";
    }
}
