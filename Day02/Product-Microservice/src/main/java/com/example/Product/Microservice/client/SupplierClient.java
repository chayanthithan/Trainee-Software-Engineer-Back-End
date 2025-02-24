package com.example.Product.Microservice.client;

import com.example.Product.Microservice.dto.SupplierDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SupplierClient",url="http://localhost:8081")
public interface SupplierClient {
    @GetMapping("/supplier")
    public String getAllSuppliers();

    @GetMapping("/supplier/{id}")
    public SupplierDto getSupplierById(@PathVariable Long id);

    @PostMapping("/supplier")
    public SupplierDto addSupplier(@RequestBody SupplierDto supplierEntity);

}
