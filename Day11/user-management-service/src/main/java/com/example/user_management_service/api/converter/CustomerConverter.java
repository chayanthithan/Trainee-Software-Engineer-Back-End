package com.example.user_management_service.api.converter;

import com.example.user_management_service.dto.CustomerDto;
import com.example.user_management_service.entity.Customer;
import com.example.user_management_service.enums.Gender;
import com.example.user_management_service.exception.ServiceException;
import com.example.user_management_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
@Component
@RequiredArgsConstructor
public class CustomerConverter {
    public Customer convert(CustomerDto customerDto){

        String names[] = customerDto.getFullName().split(" ");
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        String id = names[names.length-1]+"-"+randomNum;

            return Customer.builder()
                    .customId(id)
                    .fullName(customerDto.getFullName())
                    .address(customerDto.getAddress())
                    .nic(customerDto.getNic())
                    .gender(customerDto.getGender())
                    .email(customerDto.getEmail())
                    .dob(customerDto.getDob())
                    .salary(customerDto.getSalary()).build();
    }
}
