package com.ebusiness.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/get-products")
    public String getAllProducts(){
        return "all the products";
    }

    @GetMapping("/products-by-id")
    public String getProductById(){
        return "product by id";
    }
}
