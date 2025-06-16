package com.example.customer_service.api.controller;

import com.example.customer_service.api.dto.CustomerDto;
import com.example.customer_service.api.dto.ResponseDto;
import com.example.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Validated
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping()
    public ResponseDto addCustomer(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomerDetails(customerDto);
    }
}
