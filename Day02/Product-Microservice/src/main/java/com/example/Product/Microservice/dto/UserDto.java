package com.example.Product.Microservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private int userId;
    private String name;
    private String role;
}
