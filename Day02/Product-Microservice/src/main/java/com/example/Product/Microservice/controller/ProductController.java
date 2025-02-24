package com.example.Product.Microservice.controller;

import com.example.Product.Microservice.dto.ProductDto;
import com.example.Product.Microservice.entity.Product;
import com.example.Product.Microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping()
    public String getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping()
    public Product addProduct(@RequestBody ProductDto productDto) throws Exception {
        return productService.addProduct(productDto) ;
    }


}
