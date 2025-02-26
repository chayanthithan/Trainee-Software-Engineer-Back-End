package com.example.junit_testing.repository;

import com.example.junit_testing.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
}
