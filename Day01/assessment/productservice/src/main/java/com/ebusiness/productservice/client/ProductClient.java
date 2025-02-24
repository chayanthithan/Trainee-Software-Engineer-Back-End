package com.ebusiness.productservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "supplierService",url="http://localhost:8081")
public interface ProductClient {

}
