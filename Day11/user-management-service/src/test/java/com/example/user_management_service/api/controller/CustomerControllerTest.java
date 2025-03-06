package com.example.user_management_service.api.controller;

import com.example.user_management_service.dto.CustomerDto;
import com.example.user_management_service.dto.ResponseCustomerDto;
import com.example.user_management_service.entity.Customer;
import com.example.user_management_service.enums.Gender;
import com.example.user_management_service.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
   private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void testAddCustomerDetails_Success(){
        CustomerDto customerDto = CustomerDto.builder()
                .fullName("Manikandan Siva")
                .address("No 398/3,chennai,india")
                .nic("20003501018")
                .gender(Gender.MALE)
                .dob(LocalDate.ofEpochDay(1999-12-15))
                .email("manisiva@gmail.com")
                .salary(50000.00)
                .build();
        ResponseCustomerDto responseCustomerDto = ResponseCustomerDto.builder()
                .customId("Siva-62")
                .status("successfully created")
                .build();
        when(customerService.saveCustomersDetails(any(CustomerDto.class))).thenReturn(ResponseEntity.ok(responseCustomerDto));

        ResponseEntity<ResponseCustomerDto> responseEntity = customerController.addCustomerDetails(customerDto);
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getBody().getStatus(),"successfully created");

    }

    @Test
    public void testGetCustomerById_whenIdExist(){
        Customer customer = Customer.builder()
                .customId("Siva-01")
                .fullName("Manikandan Siva")
                .address("No 398/3,chennai,india")
                .nic("20003501018")
                .gender(Gender.MALE)
                .dob(LocalDate.ofEpochDay(1999-12-15))
                .email("manisiva@gmail.com")
                .salary(50000.00)
                .build();

        String id = "Siva-01";
        when(customerService.getCustomerById(id)).thenReturn(Optional.of(customer));
        Optional<Customer> response = customerController.getCustomerById(id);

        assertEquals(response.get().getCustomId(),"Siva-01");
        assertNotNull(response);
    }
    @Test
    public void testGetCustomerById_whenIdNotExist(){
        Customer customer = Customer.builder()
                .customId("Siva-01")
                .fullName("Manikandan Siva")
                .address("No 398/3,chennai,india")
                .nic("20003501018")
                .gender(Gender.MALE)
                .dob(LocalDate.ofEpochDay(1999-12-15))
                .email("manisiva@gmail.com")
                .salary(50000.00)
                .build();

        String id = "Siva-02";
        when(customerService.getCustomerById(id)).thenReturn(Optional.empty());
        Optional<Customer> response = customerController.getCustomerById(id);

        assertTrue(response.isEmpty(),"Not Found");
    }
}