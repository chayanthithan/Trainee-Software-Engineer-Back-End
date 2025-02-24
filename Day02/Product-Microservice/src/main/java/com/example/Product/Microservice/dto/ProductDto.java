package com.example.Product.Microservice.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Setter
@Getter
public class ProductDto {
    private String productName;
    private double productPrice;
    private Long userId;
    private Long supplierId;
    private String supplierName;
    private String supplierContactEmail;
}
