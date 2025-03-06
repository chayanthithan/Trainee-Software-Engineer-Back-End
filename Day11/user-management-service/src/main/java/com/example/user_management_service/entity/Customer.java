package com.example.user_management_service.entity;

import com.example.user_management_service.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    private String customId;
    private String fullName;
    private String address;
    private String nic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
    private LocalDate dob;
    private double salary;



}
