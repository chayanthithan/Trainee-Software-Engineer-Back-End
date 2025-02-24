package com.ebusiness.supplierservice.controller;

import com.ebusiness.supplierservice.domain.UserDto;
import com.ebusiness.supplierservice.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supplier")

public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping()
    public String getAllSupplier(){
        return supplierService.getAllSupplier();
    }
}
