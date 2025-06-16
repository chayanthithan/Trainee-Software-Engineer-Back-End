package com.example.technology_department_service.repository;

import com.example.technology_department_service.entity.Students;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Students,Long> {
    @Query("SELECT s.regNum FROM Students s WHERE s.regNum LIKE CONCAT('%/', :code, '/%') ORDER BY s.regNum DESC")
    List<String> findByCourseCode(@Param("code") String code, Pageable pageable);

    @Query("SELECT COUNT(s.regNum) FROM Students s ")
    int findAllStudentCount();
}
