package com.example.Product.Microservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonDto {
    private String productName;
    private double productPrice;
    private String supplierName;
    private String supplierContactEmail;
    private Long supplierId;
    private Long userId;

}
