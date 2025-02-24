package com.example.Product.Microservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private Long userId;
    private String role;
    private String name;
}
