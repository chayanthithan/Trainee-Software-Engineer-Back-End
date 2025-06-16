package com.example.admin_service.api.controller;

import com.example.admin_service.client.AppliedServiceClient;
import com.example.admin_service.client.ManagementServiceClient;
import com.example.admin_service.client.TechnologyServiceClient;
import com.example.admin_service.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/student-count")
    public int getTotalStudentInUniversity(){

        return adminService.getTotalOfStudent();
    }
}
