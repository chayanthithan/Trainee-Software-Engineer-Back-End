package com.example.Supplier.Microservice.repository;

import com.example.Supplier.Microservice.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
