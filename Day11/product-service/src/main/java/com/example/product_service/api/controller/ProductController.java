package com.example.product_service.api.controller;

import com.example.product_service.dto.CommonDto;
import com.example.product_service.dto.ProductDto;
import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);

    }

    @PostMapping()
    public Product addProductDetails(@RequestBody CommonDto commonDto) throws Exception{
        return productService.saveProductDetails(commonDto);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return productService.deleteProductById(id);
    }
}
