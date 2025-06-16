package com.example.customer_service.service;

import com.example.customer_service.api.dto.CustomerDto;
import com.example.customer_service.api.dto.ResponseDto;
import com.example.customer_service.conveter.CustomerConverter;
import com.example.customer_service.entity.Customer;
import com.example.customer_service.repository.CustomerRepository;
import com.example.customer_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;
    private final OrderRepository orderRepository;
    public ResponseDto saveCustomerDetails(CustomerDto customerDto) {
         Customer response = customerRepository.save(customerConverter.convert(customerDto));
         return ResponseDto.builder()
                 .name(response.getName())
                 .product(response.getOrders().get(0).getProduct())
                 .build();
    }
}
