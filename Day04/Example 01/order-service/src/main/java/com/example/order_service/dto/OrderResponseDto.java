package com.example.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
//    order
    private Long orderId;
    private Long productId;
    private int quantity;
    private double totalPrice;

// product
    private String productName;
    private double productPrice;
}
