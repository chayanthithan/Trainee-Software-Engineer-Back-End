package com.example.admin_service.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    @NotBlank(message = "name should not be blank")
    private String name;
    @NotBlank(message = "address should not be blank")
    private String address;
    @Pattern(regexp = "^07\\d{8}$")
    private String phoneNo;
    @Email(message = "email should be in the correct format")
    private String email;
}
