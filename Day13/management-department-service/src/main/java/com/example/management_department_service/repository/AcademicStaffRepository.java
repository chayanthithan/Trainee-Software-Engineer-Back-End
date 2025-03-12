package com.example.management_department_service.repository;

import com.example.management_department_service.api.dto.AcademicDtoProjection;
import com.example.management_department_service.entity.AcademicStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AcademicStaffRepository extends JpaRepository<AcademicStaff,String> {
    @Query("select new com.example.management_department_service.api.dto.AcademicDtoProjection(" +
            "a.id,a.fullName,a.job,a.faculty) " +
            "from AcademicStaff a " +
            "where a.id=:id ")
    Optional<AcademicDtoProjection> findAcademicStaffById(@Param("id") String id);

}