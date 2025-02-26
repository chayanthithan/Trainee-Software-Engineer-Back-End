package com.example.junit_testing.service;

import com.example.junit_testing.dto.EmployeeDto;
import com.example.junit_testing.entity.Employee;
import com.example.junit_testing.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository emRepository;

    public List<Employee> getAllEmployee() {
        return emRepository.findAll();
    }

    public ResponseEntity<Object> addEmployeeDetails(EmployeeDto employeeDto) {

        try {
            if(!emRepository.existsByName(employeeDto.getName())){

            Employee employee = Employee.builder()
                    .name(employeeDto.getName())
                    .age(employeeDto.getAge())
                    .salary(employeeDto.getSalary())
                    .build();
                return ResponseEntity.status(HttpStatus.CREATED).body(emRepository.save(employee));
            }

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }


        return ResponseEntity.status(HttpStatus.CONFLICT).body("name already exist");
    }

    public List<Employee> getEmployeeByName(String name) {
        List<Employee> emResponse =  emRepository.findByName(name);
        if (emResponse.isEmpty()){
            throw new NullPointerException("there is no records");
        }else{
            return emResponse;
        }
    }

    public Employee getEmployeeById(Long id) {
        return emRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = emRepository.findById(employee.getId()).orElseThrow(() -> new NullPointerException("there is no records"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setSalary(employee.getSalary());
        return emRepository.save(existingEmployee);

    }


}
