package com.example.Product.Microservice.service;

import com.example.Product.Microservice.client.SupplierClient;
import com.example.Product.Microservice.client.UserClient;
import com.example.Product.Microservice.dto.CommonDto;
import com.example.Product.Microservice.dto.ProductAndSupplierDto;
import com.example.Product.Microservice.dto.SupplierDto;
import com.example.Product.Microservice.dto.UserDto;
import com.example.Product.Microservice.entity.Product;
import com.example.Product.Microservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.naming.NoPermissionException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final SupplierClient supplierClient;
    private final UserClient userClient;
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(CommonDto commonDto) throws NoPermissionException {
        UserDto userDto = userClient.getUserById(commonDto.getUserId());
        SupplierDto supplierDto = supplierClient.getSupplierById(commonDto.getSupplierId());

        if(userDto == null){
            throw new NullPointerException("there is no userId in the DB");
        }
        if(!userDto.getRole().equals("ADMIN")){
            throw new NoPermissionException("this particular user not allowed to add product");
        }
        if(supplierDto == null){
            SupplierDto supplierDto1 = SupplierDto.builder()
                    .name(commonDto.getSupplierName())
                    .contactEmail(commonDto.getSupplierContactEmail())
                    .build();
            supplierClient.addSupplier(supplierDto1);
        }

        Product product = Product.builder()
                .name(commonDto.getProductName())
                .price(commonDto.getProductPrice())
                .build();
        return productRepository.save(product);
    }

    public ProductAndSupplierDto linkProductAndSupplier(Long productId, Long supplierId) {
        Product product = productRepository.findById(productId).orElse(null);
        SupplierDto supplierDto = supplierClient.getSupplierById(supplierId);

        if(product == null){
            throw new NullPointerException("there is not product in the given productId");
        }
        if(supplierDto == null){
           throw new NullPointerException("there is no supplier in the given supplierId");
        }
        return ProductAndSupplierDto.builder()
                .productName(product.getName())
                .productPrice(product.getPrice())
                .supplierName(supplierDto.getName())
                .supplierContactEmail(supplierDto.getContactEmail())
                .build();
    }
}
