package com.ebusiness.supplierservice.service;

import com.ebusiness.supplierservice.client.UserClient;
import com.ebusiness.supplierservice.domain.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupplierService {
    @Autowired
    UserClient userClient;
    public String getAllSupplier() {
        List<UserDto> userDtoList = userClient.getAllUsers();
        System.out.println(userDtoList);
        return "userDto List";
    }
}
