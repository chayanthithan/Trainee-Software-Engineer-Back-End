package com.example.supplier_service.api.controller;

import com.example.supplier_service.dto.SupplierDto;
import com.example.supplier_service.entity.Supplier;
import com.example.supplier_service.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping()
    public ResponseEntity<List<Supplier>> getAllSupplier(){
        return new ResponseEntity<>(supplierService.getAllSupplier(),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Supplier>> getSupplierById(@PathVariable Long id){
        Optional<Supplier> response = supplierService.getSupplierById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping()
    public Supplier addSupplierDetails(@RequestBody SupplierDto supplierDto){
        return supplierService.saveSupplierDetails(supplierDto);
    }

    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable Long id){
        return supplierService.deleteSupplierById(id);
    }
}
