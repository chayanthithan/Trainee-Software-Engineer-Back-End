package com.example.junit_testing.service;

import com.example.junit_testing.dto.EmployeeDto;
import com.example.junit_testing.entity.Employee;
import com.example.junit_testing.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;
    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp(){

        employee = Employee.builder()
                .id(1L)
                .name("chayan kumar")
                .salary(20000.00)
                .age(25)
                .build();
    }

    @Test
    void testGetAllEmployee() {
        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        List<Employee> employees = employeeService.getAllEmployee();

        assertEquals(1,employees.size());
        assertEquals("chayan kumar",employees.get(0).getName());
        verify(employeeRepository,times(1)).findAll();
    }

    @Test
    void testAddEmployeeDetails() {

        EmployeeDto employeeDto =EmployeeDto.builder()
                .name("chayan kumar")
                .salary(20000.00)
                .age(25)
                .build();
     when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
     Employee employee1 = (Employee) employeeService.addEmployeeDetails(employeeDto).getBody();
     assertNotNull(employee1);
     assertEquals("chayan kumar",employee1.getName());
     verify(employeeRepository,times(1)).save(any(Employee.class));

    }
    @Test
    void testGetEmployeeByName_Success(){

        when(employeeRepository.findByName("chayan kumar")).thenReturn(List.of(employee));
        List<Employee> employee1 = employeeService.getEmployeeByName("chayan kumar");
        assertFalse(employee1.isEmpty());
        assertNotNull(employee1);
        verify(employeeRepository,times(1)).findByName("chayan kumar");
    }
    @Test
    void testGetEmployeeByName_NotFound(){
        when(employeeRepository.findByName("chayan kumar")).thenReturn(List.of());

        Exception exception = assertThrows(NullPointerException.class,() -> employeeService.getEmployeeByName("chayan kumar"));
        assertEquals("there is no records",exception.getMessage());
        verify(employeeRepository,times(1)).findByName("chayan kumar");
    }

    @Test
    void testGetEmployeeById_Success(){
        when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));

        Employee employee1 = employeeService.getEmployeeById(1L);

        assertEquals("chayan kumar",employee1.getName());
        assertNotNull(employee1);
        verify(employeeRepository,times(1)).findById(1L);
    }

    @Test
    void testGetEmployeeById_NotFound(){
        when(employeeRepository.findById(2L)).thenReturn(Optional.empty());

        Employee employee1 = employeeService.getEmployeeById(2L);
        assertNull(employee1);
        verify(employeeRepository,times(1)).findById(2L);

    }
    @Test
    void testUpdateEmployee(){

        employee = Employee.builder()
                .id(1L)
                .name("chayan kumar")
                .salary(20000.00)
                .age(25)
                .build();

        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee employee1 = employeeService.updateEmployee(employee);

        assertNotNull(employee1);
        assertEquals("chayan kumar",employee1.getName());
    }
}