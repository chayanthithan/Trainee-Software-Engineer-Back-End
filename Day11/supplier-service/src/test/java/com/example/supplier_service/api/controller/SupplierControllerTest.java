package com.example.supplier_service.api.controller;

import com.example.supplier_service.entity.Supplier;
import com.example.supplier_service.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class SupplierControllerTest {

    @Mock
    private SupplierService supplierService;

    @InjectMocks
    private SupplierController supplierController;

    @Test
    void testGetAllSupplier_WhenSuccess(){
        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();
        when(supplierService.getAllSupplier()).thenReturn(List.of(supplier));

        ResponseEntity<List<Supplier>> response = supplierController.getAllSupplier();
        assertEquals(response.getBody().get(0).getName(),"test");
        assertEquals(response.getStatusCode(),HttpStatus.OK);
    }
    @Test
    void testGetAllSupplier_whenFailure(){
        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();
        when(supplierService.getAllSupplier()).thenReturn(new ArrayList<>());

        ResponseEntity<List<Supplier>> response = supplierController.getAllSupplier();
        assertTrue(response.getBody().isEmpty());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

    @Test
    void testGetSupplierById_whenSupplierIdExist(){
        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();

        Long id = 1L;

        when(supplierService.getSupplierById(id)).thenReturn(Optional.of(supplier));
        ResponseEntity<Optional<Supplier>> response = supplierController.getSupplierById(id);

        assertEquals(response.getStatusCode(),HttpStatus.OK);

    }
    @Test
    void testGetSupplierById_whenSupplierIdNotExist(){
        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();

        Long id = 1L;

        when(supplierService.getSupplierById(id)).thenReturn(Optional.empty());
        ResponseEntity<Optional<Supplier>> response = supplierController.getSupplierById(id);

        assertTrue(response.getBody().isEmpty());
        assertEquals(response.getStatusCode(),HttpStatus.OK);

    }


}