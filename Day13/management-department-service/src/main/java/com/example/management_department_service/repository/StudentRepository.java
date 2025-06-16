package com.example.management_department_service.repository;

import com.example.management_department_service.api.dto.StudentResponseDto;
import com.example.management_department_service.api.dto.StudentResponseDtoNew;
import com.example.management_department_service.entity.Students;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Students,String> {
    @Query("SELECT s.regNum FROM Students s WHERE s.regNum LIKE CONCAT('%/', :code, '/%') ORDER BY s.regNum DESC")
    List<String> findByCourseCode(@Param("code") String code, Pageable pageable);

    @Query("select new com.example.management_department_service.api.dto.StudentResponseDtoNew(" +
            "s.regNum,s.fullName,s.course) " +
            "from Students s ")
    List<StudentResponseDtoNew> getAllStudentDetails();

    @Query("SELECT COUNT(s.regNum) FROM Students s ")
    int findAllStudentCount();
}
//
//    @Query("SELECT new com.codelantic.marketplace.product.service.dto.ProductResponseDto(" +
//            "p.id, p.productName) " +
//            "FROM Product p " +
//            "WHERE p.status = true")
//    List<ProductResponseDto> getAllProductDetails();