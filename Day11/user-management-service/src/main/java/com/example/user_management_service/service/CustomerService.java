package com.example.user_management_service.service;

import com.example.user_management_service.api.converter.CustomerConverter;
import com.example.user_management_service.dto.CustomerDto;
import com.example.user_management_service.dto.ResponseCustomerDto;
import com.example.user_management_service.entity.Customer;
import com.example.user_management_service.exception.ServiceException;
import com.example.user_management_service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;
    public ResponseEntity<ResponseCustomerDto> saveCustomersDetails(CustomerDto customerDto) {
        Customer convertedDto = customerConverter.convert(customerDto);

        Optional<Customer> customer = customerRepository.findByCustomId(convertedDto.getCustomId());
        if(customer.isPresent()){
            throw new ServiceException("User already exist","Already Exist","Already Exist");
        }
        Customer response = customerRepository.save(convertedDto);
        ResponseCustomerDto responseCustomerDto = ResponseCustomerDto.builder()
                .customId(response.getCustomId())
                .status("successfully created")
                .build();
        return new ResponseEntity<>(responseCustomerDto,HttpStatus.OK);
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findByCustomId(id);

    }
}
