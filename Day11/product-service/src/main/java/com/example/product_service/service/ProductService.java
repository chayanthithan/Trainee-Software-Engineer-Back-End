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
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.NoPermissionException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final SupplierClient supplierClient;
    private final UserClient userClient;
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;


    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProductDetails(CommonDto commonDto) throws Exception{
//        get user by id
        UserDto user = userClient.getUserById(commonDto.getUserId());

        if(user == null || !user.getRole().equals("ADMIN")){
            throw new NoPermissionException("can't add");
        }
//        get supplier by id
        SupplierDto supplierRespnse = supplierClient.getSupplierById(commonDto.getSupplierDto().getId());
        if(supplierRespnse == null){
            SupplierDto supplierDto = supplierClient.addSupplierDetails(commonDto.getSupplierDto());
        }

        return productRepository.save(productConverter.convert(commonDto.getProductDto()));
    }

    public String deleteProductById(Long id) {
        try{
            productRepository.deleteById(id);
            return "Successfully deleted";
        }catch (NullPointerException e){
            throw new NullPointerException(e.getMessage());
        }


    }
}
