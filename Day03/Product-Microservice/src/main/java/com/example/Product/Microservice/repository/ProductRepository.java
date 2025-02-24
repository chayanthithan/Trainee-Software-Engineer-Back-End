package com.example.Product.Microservice.repository;

import com.example.Product.Microservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
