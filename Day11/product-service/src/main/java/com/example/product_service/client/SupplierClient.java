package com.example.product_service.client;

import com.example.product_service.dto.SupplierDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "supplierService",url = "${supplier.name}")
public interface SupplierClient {
    @GetMapping("/supplier")
    public List<SupplierDto> getAllSupplier();

    @GetMapping("supplier/{id}")
    public SupplierDto getSupplierById(@PathVariable Long id);

    @PostMapping("/supplier")
    public SupplierDto addSupplierDetails(@RequestBody SupplierDto supplierDto);

    @DeleteMapping("supplier/{id}")
    public String deleteSupplier(@PathVariable Long id);
}
