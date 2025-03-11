package com.example.supplier_service.service;

import com.example.supplier_service.api.converter.SupplierConverter;
import com.example.supplier_service.dto.SupplierDto;
import com.example.supplier_service.entity.Supplier;
import com.example.supplier_service.repository.SupplierRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class SupplierServiceTest {

    @Mock
    private SupplierRepository supplierRepository;
    @Mock
    private SupplierConverter supplierConverter;

    @InjectMocks
    private SupplierService supplierService;

    @Test
    void testGetAllSupplier(){
        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();
        when(supplierRepository.findAll()).thenReturn(List.of(supplier));
        List<Supplier> response = supplierService.getAllSupplier();

        assertEquals("test",response.get(0).getName());
    }
    @Test
    void testGetAllSupplier_whenSupplierEmpty(){
        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();
        when(supplierRepository.findAll()).thenReturn(new ArrayList<>());
        List<Supplier> response = supplierService.getAllSupplier();

        assertTrue(response.isEmpty());
    }
    @Test
    void testGetSupplierById_whenIdExist(){
        Long id = 1L;
        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();
        when(supplierRepository.findById(id)).thenReturn(Optional.of(supplier));
        Optional<Supplier> response = supplierService.getSupplierById(id);

        assertEquals("test",response.get().getName());

    }

    @Test
    void testGetSupplierById_whenIdNotExist(){
        Long id = 1L;
        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();
        when(supplierRepository.findById(id)).thenReturn(Optional.empty());
        Optional<Supplier> response = supplierService.getSupplierById(id);

        assertTrue(response.isEmpty(),"Supplier is not available");

    }

    @Test
    void testSaveSupplierDetails_Success(){
        SupplierDto supplierDto = SupplierDto.builder()
                .contactEmail("test")
                .name("test")
                .build();

        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();

        when(supplierConverter.convert(supplierDto)).thenReturn(supplier);
        when(supplierRepository.save(supplier)).thenReturn(supplier);
        Supplier response = supplierService.saveSupplierDetails(supplierDto);
         assertEquals(response.getName(),"test");

    }

    @Test
    void testSaveSupplierDetails_Failure(){
        SupplierDto supplierDto = SupplierDto.builder()
                .contactEmail("test")
                .name("test")
                .build();

        Supplier supplier = Supplier.builder()
                .id(1L)
                .contactEmail("test")
                .name("test")
                .build();

        when(supplierConverter.convert(supplierDto)).thenReturn(supplier);
        when(supplierRepository.save(supplier)).thenThrow(new RuntimeException("Invalid Data"));
        Exception exception = assertThrows(RuntimeException.class,() -> supplierService.saveSupplierDetails(supplierDto));

    }

    @Test
    void testDeleteSupplierById(){
        Long id = 1L;
        when(supplierRepository.existsById(id)).thenReturn(true);
//        doNothing().when(supplierRepository.deleteById(id));

        String response = supplierService.deleteSupplierById(id);
        assertEquals(response,"Successfully deleted");
    }
    @Test
    void testDeleteSupplierById_NotExistId(){
        Long id = 1L;
        when(supplierRepository.existsById(id)).thenReturn(false);
//        doNothing().when(supplierRepository.deleteById(id));

        Exception exception = assertThrows(NullPointerException.class,()-> supplierService.deleteSupplierById(id));
        assertEquals(exception.getMessage(),"there  is no records");
    }

}