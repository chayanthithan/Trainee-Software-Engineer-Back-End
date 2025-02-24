package com.example.product_microservice;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/product-service")
public class ProductController {

//    private final RestTemplate restTemplate;

//    @Autowired
    FeignInterface feignInterface;
    public String product(){
        return feignInterface.home();
//        String homeResponse = restTemplate.getForObject("http://HOME-MICROSERVICE/home",String.class);
//        return homeResponse;
    }
}
