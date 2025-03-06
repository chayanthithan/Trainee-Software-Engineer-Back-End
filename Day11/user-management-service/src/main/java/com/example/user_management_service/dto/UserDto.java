package com.example.user_management_service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class UserDto {

    @Positive(message = "UserId should not be positive")
    private Long userId;

    @NotEmpty(message = "name should not be empty or null")
    private String name;
    @NotEmpty(message = "role should not be empty or null")
    private String role;
}
