package com.example.supplier_service.api.converter;

import com.example.supplier_service.dto.SupplierDto;
import com.example.supplier_service.entity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierConverter {

    public Supplier convert(SupplierDto supplierDto){
        return Supplier.builder()
                .name(supplierDto.getName())
                .contactEmail(supplierDto.getContactEmail())
                .build();
    }
}
