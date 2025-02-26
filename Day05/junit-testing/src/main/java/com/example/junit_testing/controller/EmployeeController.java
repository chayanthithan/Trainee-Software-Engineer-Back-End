package com.example.junit_testing.controller;

import com.example.junit_testing.dto.EmployeeDto;
import com.example.junit_testing.entity.Employee;
import com.example.junit_testing.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping()
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }

    @PostMapping()
    public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDto employeeDto){
        return service.addEmployeeDetails(employeeDto);
    }

    @GetMapping("/{name}")
    public List<Employee> getByName(@PathVariable String name){
        return service.getEmployeeByName(name);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return service.getEmployeeById(id);
    }

    @PutMapping()
    public Employee updateExistingEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }
}
