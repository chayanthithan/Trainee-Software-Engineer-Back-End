package com.example.applied_science_department_service.repository;

import com.example.applied_science_department_service.entity.NonAcademicStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonAcademicStaffRepository extends JpaRepository<NonAcademicStaff,String> {
}
