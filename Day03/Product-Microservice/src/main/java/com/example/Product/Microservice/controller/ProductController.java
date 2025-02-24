package com.example.Product.Microservice.controller;

import com.example.Product.Microservice.dto.CommonDto;
import com.example.Product.Microservice.dto.ProductAndSupplierDto;
import com.example.Product.Microservice.entity.Product;
import com.example.Product.Microservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.naming.NoPermissionException;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping()
    public Product addProduct(@RequestBody CommonDto commonDto) throws NoPermissionException {
        return productService.addProduct(commonDto);
    }

    @GetMapping("/link/{productId}/supplier/{supplierId}")
    public ProductAndSupplierDto linkProductAndSupplier(@PathVariable Long productId, @PathVariable Long supplierId){
        return productService.linkProductAndSupplier(productId,supplierId);
    }

}
