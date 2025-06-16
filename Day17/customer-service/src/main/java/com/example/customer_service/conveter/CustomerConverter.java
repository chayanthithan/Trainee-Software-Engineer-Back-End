package com.example.customer_service.conveter;

import com.example.customer_service.api.dto.CustomerDto;
import com.example.customer_service.entity.Customer;
import com.example.customer_service.entity.Orders;
import com.example.customer_service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerConverter {
    private final CustomerRepository customerRepository;

    public Customer convert(CustomerDto customerDto){
        Customer customer = new Customer();

        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());

        List<Orders> orders = customerDto.getOrders()
                .stream()
                .peek(order -> order.setCustomer(customer))
                .toList();

        customer.setOrders(orders);
        return customer;
    }
}
