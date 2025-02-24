package com.example.Product.Microservice.service;

import com.example.Product.Microservice.Repository.ProductRepository;
import com.example.Product.Microservice.client.SupplierClient;
import com.example.Product.Microservice.client.UserClient;
import com.example.Product.Microservice.dto.ProductDto;
import com.example.Product.Microservice.dto.SupplierDto;
import com.example.Product.Microservice.dto.UserDto;
import com.example.Product.Microservice.entity.Product;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NoPermissionException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;

    private final UserClient userClient;

    private final SupplierClient supplierClient;
    public String getAllProducts() {
        return supplierClient.getAllSuppliers();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product addProduct(ProductDto productDto) throws Exception {

        UserDto userDto = userClient.getUserById(productDto.getUserId());

            if(userDto == null){
                throw new NoSuchFieldException("there is no User ");
            }
            if(!"ADMIN".equals(userDto.getRole())){
                throw new NoPermissionException("This particular user don't have the permission to add");
            }



            SupplierDto supplierDto = supplierClient.getSupplierById(productDto.getSupplierId());
            if (supplierDto == null) {

                SupplierDto supplierDto1 = SupplierDto.builder()
                        .name(productDto.getSupplierName())
                        .contactEmail(productDto.getSupplierContactEmail())
                        .build();
                SupplierDto supplierDtoResponse = supplierClient.addSupplier(supplierDto1);

            }
        Product product = Product.builder()
                    .name(productDto.getProductName())
                    .price(productDto.getProductPrice())
                    .build();
            return productRepository.save(product);

    }

}
