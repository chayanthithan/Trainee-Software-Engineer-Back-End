package com.example.user_management_service.api.controller;

import com.example.user_management_service.dto.CustomerDto;
import com.example.user_management_service.dto.ResponseCustomerDto;
import com.example.user_management_service.entity.Customer;
import com.example.user_management_service.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Validated
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping()
    public ResponseEntity<ResponseCustomerDto> addCustomerDetails(@Valid @RequestBody CustomerDto customerDto){
        return customerService.saveCustomersDetails(customerDto);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id){
        return customerService.getCustomerById(id);
    }
}
