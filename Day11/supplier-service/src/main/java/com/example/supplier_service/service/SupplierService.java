package com.example.supplier_service.service;

import com.example.supplier_service.api.converter.SupplierConverter;
import com.example.supplier_service.dto.SupplierDto;
import com.example.supplier_service.entity.Supplier;
import com.example.supplier_service.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {
    
    private final SupplierRepository supplierRepository;
    private final SupplierConverter supplierConverter;
    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    public Supplier saveSupplierDetails(SupplierDto supplierDto) {
        return supplierRepository.save(supplierConverter.convert(supplierDto));
    }

    public String deleteSupplierById(Long id) {
        if(supplierRepository.existsById(id)){
            supplierRepository.deleteById(id);
            return "Successfully deleted";
        }else{
            throw new NullPointerException("there  is no records");
        }
    }
}
