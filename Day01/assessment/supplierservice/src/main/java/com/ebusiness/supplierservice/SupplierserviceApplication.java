package com.ebusiness.supplierservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SupplierserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierserviceApplication.class, args);
	}

}
