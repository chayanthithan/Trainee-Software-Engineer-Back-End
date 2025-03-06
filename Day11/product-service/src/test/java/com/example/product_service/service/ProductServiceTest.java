package com.example.product_service.service;

import com.example.product_service.api.converter.ProductConverter;
import com.example.product_service.client.SupplierClient;
import com.example.product_service.client.UserClient;
import com.example.product_service.dto.CommonDto;
import com.example.product_service.dto.ProductDto;
import com.example.product_service.dto.SupplierDto;
import com.example.product_service.dto.UserDto;
import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.naming.NoPermissionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private SupplierClient supplierClient;
    @Mock
    private UserClient userClient;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductConverter productConverter;

    @InjectMocks
    private ProductService productService;

    @Test
    void testGetAllProduct_whenReturnProducts(){
        Product product = Product.builder()
                .id(1L)
                .name("test")
                .price(14500.00)
                .build();
        when(productRepository.findAll()).thenReturn(List.of(product));
        List<Product> response = productService.getAllProduct();
        assertNotNull(response);
        assertEquals("test",response.get(0).getName());
    }

    @Test
    void testGetAllProduct_whenReturnEmpty(){
        Product product = Product.builder()
                .id(1L)
                .name("test")
                .price(14500.00)
                .build();
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        List<Product> response = productService.getAllProduct();
        assertTrue(response.isEmpty());

    }

    @Test
    void testGetProductById_whenIdExist(){
        Product product = Product.builder()
                .id(1L)
                .name("test")
                .price(14500.00)
                .build();
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Optional<Product> response = productService.getProductById(1L);
        assertNotNull(response);
        assertEquals("test",response.get().getName());
    }
    @Test
    void testGetProductById_whenIdNotExist(){
        Product product = Product.builder()
                .id(1L)
                .name("test")
                .price(14500.00)
                .build();
        when(productRepository.findById(2L)).thenReturn(Optional.empty());
        Optional<Product> response = productService.getProductById(2L);
        assertTrue(response.isEmpty());
    }

    @Test
    void testSaveProductDetails_Success() throws Exception {
        CommonDto commonDto = CommonDto.builder()
                .userId(1L)
                .productDto(
                        new ProductDto().builder()
                                .name("test")
                                .price(14500.00)
                                .build()
                )
                .supplierDto(
                        new SupplierDto().builder()
                                .contactEmail("test")
                                .name("test")
                                .build()
                )
                .build();

        UserDto user = UserDto.builder()
                .Id(1L)
                .name("test")
                .role("ADMIN")
                .build();
        SupplierDto supplierDto = SupplierDto.builder()
                .contactEmail("test")
                .name("test")
                .build();
        Product product = Product.builder()
                .id(1L)
                .name("test")
                .price(14500.00)
                .build();
        when(userClient.getUserById(commonDto.getUserId())).thenReturn(user);
        when(supplierClient.getSupplierById(commonDto.getSupplierDto().getId())).thenReturn(supplierDto);
        when(productRepository.save(productConverter.convert(commonDto.getProductDto()))).thenReturn(product);

        Product response = productService.saveProductDetails(commonDto);
        assertNotNull(response);
        assertEquals("test",response.getName());
    }
    @Test
    void testSaveProductDetails_Failure_whenUserRoleNotADMIN() throws Exception {
        CommonDto commonDto = CommonDto.builder()
                .userId(1L)
                .productDto(
                        new ProductDto().builder()
                                .name("test")
                                .price(14500.00)
                                .build()
                )
                .supplierDto(
                        new SupplierDto().builder()
                                .contactEmail("test")
                                .name("test")
                                .build()
                )
                .build();

        UserDto user = UserDto.builder()
                .Id(1L)
                .name("test")
                .role("test") //ADMIN only allow
                .build();
        SupplierDto supplierDto = SupplierDto.builder()
                .contactEmail("test")
                .name("test")
                .build();
        Product product = Product.builder()
                .id(1L)
                .name("test")
                .price(14500.00)
                .build();
        when(userClient.getUserById(commonDto.getUserId())).thenReturn(null);
//        when(supplierClient.getSupplierById(commonDto.getSupplierDto().getId())).thenReturn(supplierDto);
//        when(productRepository.save(productConverter.convert(commonDto.getProductDto()))).thenReturn(product);

        Exception exception = assertThrows(NoPermissionException.class,()->productService.saveProductDetails(commonDto));
        assertEquals(exception.getMessage(),"can't add");

    }
    @Test
    void testSaveProductDetails_Failure_whenUserNotExist() throws Exception {
        CommonDto commonDto = CommonDto.builder()
                .userId(1L)
                .productDto(
                        new ProductDto().builder()
                                .name("test")
                                .price(14500.00)
                                .build()
                )
                .supplierDto(
                        new SupplierDto().builder()
                                .contactEmail("test")
                                .name("test")
                                .build()
                )
                .build();

        UserDto user = UserDto.builder()
                .Id(1L)
                .name("test")
                .role("ADMIN") //ADMIN only allow
                .build();
        SupplierDto supplierDto = SupplierDto.builder()
                .contactEmail("test")
                .name("test")
                .build();
        Product product = Product.builder()
                .id(1L)
                .name("test")
                .price(14500.00)
                .build();
        when(userClient.getUserById(1L)).thenReturn(null);
//        when(supplierClient.getSupplierById(commonDto.getSupplierDto().getId())).thenReturn(supplierDto);
//        when(productRepository.save(productConverter.convert(commonDto.getProductDto()))).thenReturn(product);

        Exception exception = assertThrows(NoPermissionException.class,()->productService.saveProductDetails(commonDto));
        assertEquals(exception.getMessage(),"can't add");

    }

    @Test
    void testDeleteProductById(){
        Long id = 1L;
        doNothing().when(productRepository).deleteById(1L);
        String response = productService.deleteProductById(id);

        assertEquals(response,"Successfully deleted");
    }
}