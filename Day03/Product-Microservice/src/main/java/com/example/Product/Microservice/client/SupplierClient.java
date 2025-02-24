package com.example.Product.Microservice.client;

import com.example.Product.Microservice.dto.SupplierDto;
import lombok.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



@FeignClient(name = "SupplierClient",url = "${supplier.service.url}")
public interface SupplierClient {
    @GetMapping("/supplier")
    public List<SupplierDto> getAllSuppliers();

    @GetMapping("supplier/{id}")
    public SupplierDto getSupplierById(@PathVariable Long id);

    @PostMapping("/supplier")
    public SupplierDto addSupplier(@RequestBody SupplierDto supplier);

}
