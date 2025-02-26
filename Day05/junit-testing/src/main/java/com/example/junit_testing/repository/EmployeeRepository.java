package com.example.junit_testing.repository;

import com.example.junit_testing.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByName(String name);

    boolean existsByName(String name);
}
