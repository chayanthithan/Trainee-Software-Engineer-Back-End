package com.example.product_service.api.controller;

import com.example.product_service.dto.CommonDto;
import com.example.product_service.dto.ProductDto;
import com.example.product_service.dto.SupplierDto;
import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private Product product;
    private CommonDto commonDto;
    @BeforeEach
    void setUp() {
        product = Product.builder()
                .id(1L)
                .price(14500.00)
                .name("mother board")
                .build();

        commonDto = CommonDto.builder()
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
    }

    @Test
    void testGetAllProduct_whenReturnProduct(){
       when(productService.getAllProduct()).thenReturn(List.of(product));

       ResponseEntity<List<Product>> response = productController.getAllProduct();

       assertNotNull(response);
//       assertEquals("mother board",response.get(0).getName());
        assertEquals(HttpStatus.OK,response.getStatusCode());
       verify(productService,times(1)).getAllProduct();
    }

    @Test
    void testGetAllProduct_whenReturnEmpty(){
        when(productService.getAllProduct()).thenReturn(new ArrayList<>());

        Exception exception = assertThrows(NullPointerException.class,() -> productController.getAllProduct());
        assertEquals(exception.getMessage(),"There is no records in the DB");

    }

    @Test
    void testGetProductById_whenIdExist(){
        when(productService.getProductById(1L)).thenReturn(Optional.of(product));

        Optional<Product> response = productController.getProductById(1L);
        assertNotNull(response);

    }
    @Test
    void testGetProductById_whenIdNotExist(){
        when(productService.getProductById(2L)).thenReturn(null);
        Exception exception = assertThrows(NullPointerException.class,() -> productController.getProductById(2L));
        assertEquals(exception.getMessage(),"There is no records in the DB");
        verify(productService,times(1)).getProductById(2L);

    }

    @Test
    void testAddProductDetails_Success() throws Exception {
        when(productService.saveProductDetails(any(CommonDto.class))).thenReturn(product);

        Product addResponse = productController.addProductDetails(commonDto);

        assertNotNull(addResponse);
     }
    @Test
    void testAddProductDetails_Failure() throws Exception {
        when(productService.saveProductDetails(any(CommonDto.class))).thenReturn(null);

        Product addResponse = productController.addProductDetails(commonDto);

        assertNull(addResponse);
        verify(productService,times(1)).saveProductDetails(commonDto);
    }

    @Test
    void testDeleteUser_whenIdExist(){
    when(productService.deleteProductById(1L)).thenReturn("Successfully deleted");
    String response = productController.deleteUser(1L);
    assertEquals("Successfully deleted",response);
    verify(productService,times(1)).deleteProductById(1L);
    }


}