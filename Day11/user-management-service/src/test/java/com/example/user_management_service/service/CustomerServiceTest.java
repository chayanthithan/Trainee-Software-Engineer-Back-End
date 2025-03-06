package com.example.user_management_service.service;

import com.example.user_management_service.api.converter.CustomerConverter;
import com.example.user_management_service.dto.CustomerDto;
import com.example.user_management_service.dto.ResponseCustomerDto;
import com.example.user_management_service.entity.Customer;
import com.example.user_management_service.enums.Gender;
import com.example.user_management_service.exception.ServiceException;
import com.example.user_management_service.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerConverter customerConverter;
    @InjectMocks
    private CustomerService customerService;

    @Test
    void testSaveCustomerDetails_Success(){
        CustomerDto customerDto = CustomerDto.builder()
                .fullName("Manikandan Siva")
                .address("No 398/3,chennai,india")
                .nic("20003501018")
                .gender(Gender.MALE)
                .dob(LocalDate.ofEpochDay(1999-12-15))
                .email("manisiva@gmail.com")
                .salary(50000.00)
                .build();

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
        ResponseCustomerDto responseCustomerDto = ResponseCustomerDto.builder()
                .customId("Siva-01")
                .status("successfully created")
                .build();

        when(customerConverter.convert(any(CustomerDto.class))).thenReturn(customer);
        when(customerRepository.findByCustomId(customer.getCustomId())).thenReturn(Optional.empty());
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        ResponseEntity<ResponseCustomerDto> response = customerService.saveCustomersDetails(customerDto);
        assertNotNull(response);
        assertEquals(response.getBody(),responseCustomerDto);
    }
    @Test
    void testSaveCustomerDetails_Failure(){
        CustomerDto customerDto = CustomerDto.builder()
                .fullName("Manikandan Siva")
                .address("No 398/3,chennai,india")
                .nic("20003501018")
                .gender(Gender.MALE)
                .dob(LocalDate.ofEpochDay(1999-12-15))
                .email("manisiva@gmail.com")
                .salary(50000.00)
                .build();

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
        ResponseCustomerDto responseCustomerDto = ResponseCustomerDto.builder()
                .customId("Siva-01")
                .status("successfully created")
                .build();

        when(customerConverter.convert(any(CustomerDto.class))).thenReturn(customer);
        when(customerRepository.findByCustomId(customer.getCustomId())).thenReturn(Optional.of(customer));

        Exception exception = assertThrows(ServiceException.class,() -> customerService.saveCustomersDetails(customerDto));
        assertEquals(exception.getMessage(),"User already exist");
    }

    @Test
    void testGetCustomerById_whenCustomerIdExist(){
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
        when(customerRepository.findByCustomId(id)).thenReturn(Optional.of(customer));
        Optional<Customer> response = customerService.getCustomerById(id);

        assertNotNull(response);
        assertEquals(response.get().getCustomId(),"Siva-01");
    }

    @Test
    void testGetCustomerById_whenCustomerIdNotExist(){
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
        when(customerRepository.findByCustomId(id)).thenReturn(Optional.empty());
        Optional<Customer> response = customerService.getCustomerById(id);

        assertTrue(response.isEmpty(),"Customer is Not Found");

    }
}