package com.example.user_management_service.dto;

import com.example.user_management_service.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class CustomerDto {
    @NotEmpty(message = "name should not be empty or null")
    private String fullName;
    @NotEmpty(message = "address should not be empty or null")
    private String address;
    @Pattern(regexp = "^(?:\\d{9}[XV]|\\d{11})$")
    private String nic;
//    @NotBlank(message = "Gender should not be empty,null and white-space")
    private Gender gender;
    @NotBlank(message = "Email should not be empty,null and white-space")
    @Email(regexp = "^[A-Za-z0-9_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$"
            , message = "Invalid email format. Please provide a valid Activated by mail address.")
    private String email;
    @Past(message = "date should be past")
    private LocalDate dob;
    @Positive(message = "salary should be greater than 0")
    private double salary;
}
