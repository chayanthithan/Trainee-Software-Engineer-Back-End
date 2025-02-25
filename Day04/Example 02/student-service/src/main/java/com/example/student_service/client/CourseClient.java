package com.example.student_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "course-service",url = "${course.service.url}")
public interface CourseClient {
}
