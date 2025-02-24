package com.example.Supplier.Microservice.controller;

import com.example.Supplier.Microservice.entity.Supplier;
import com.example.Supplier.Microservice.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping()
    public String getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id){
        return supplierService.getSupplierById(id);
    }

    @PostMapping()
    public Supplier addSupplier(@RequestBody Supplier supplierEntity){
        return supplierService.addSupplier(supplierEntity);
    }
}
