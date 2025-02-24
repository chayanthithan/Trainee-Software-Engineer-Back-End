package com.example.Supplier.Microservice.service;

import com.example.Supplier.Microservice.entity.Supplier;
import com.example.Supplier.Microservice.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;


    public String getAllSuppliers() {
        return "list of suppliers are here";
    }


    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier addSupplier(Supplier supplierEntity) {
        return supplierRepository.save(supplierEntity);
    }
}

