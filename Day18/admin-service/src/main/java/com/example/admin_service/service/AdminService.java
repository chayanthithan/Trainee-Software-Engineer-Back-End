package com.example.admin_service.service;

import com.example.admin_service.client.AppliedServiceClient;
import com.example.admin_service.client.ManagementServiceClient;
import com.example.admin_service.client.TechnologyServiceClient;
import com.example.admin_service.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final AppliedServiceClient appliedServiceClient;
    private final ManagementServiceClient managementServiceClient;
    private final TechnologyServiceClient technologyServiceClient;
    public int getTotalOfStudent() {
        int applied_Student_Count = appliedServiceClient.getAppliedStudentCount();
        int technology_Student_Count = technologyServiceClient.getAppliedStudentCount();
        int management_Student_Count = managementServiceClient.getAppliedStudentCount();
        return applied_Student_Count + technology_Student_Count + management_Student_Count;
    }
}
