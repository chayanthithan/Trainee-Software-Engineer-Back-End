package com.example.Product.Microservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductAndSupplierDto {
    private String productName;
    private double productPrice;
    private Long supplierId;
    private String supplierName;
    private String supplierContactEmail;


}
