package com.example.product_service.api.converter;

import com.example.product_service.dto.ProductDto;
import com.example.product_service.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product convert(ProductDto productDto){
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();

    }
}
