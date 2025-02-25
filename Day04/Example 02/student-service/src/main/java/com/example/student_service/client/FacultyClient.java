package com.example.student_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "faculty-client",url = "${}")
public interface FacultyClient {
}
