package com.example.hw052923.service;

import com.example.hw052923.DepartmentService;
import com.example.hw052923.DepartmentServiceImpl;
import com.example.hw052923.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class DepartmentServiceImplTest {
    private EmployeeService employeeService;

@InjectMocks
    private DepartmentService departmentService;
@BeforeEach
    public void setUP(){
        EmployeeService employeeService = mock(EmployeeService.class);
        when(employeeService.getAll()).thenReturn(employeeList());

        departmentService = new DepartmentServiceImpl(employeeService);

    }


    private List<Employee> employeeList(){
        return  List.of(new Employee("Ivan", "Ivanov", 1, 2000),
                new Employee("Petr", "Petrov", 1, 22000),
                new Employee("Boris", "Britva", 1, 12000));
    }
@Test
    public void shouldReturnEmployeeWithMaxSalary(){
    Employee employee = departmentService.findEmployeeMaxSalary(1);

        Assertions.assertEquals("Petr",employee.getFirstName());
        Assertions.assertEquals("Petrov",employee.getLastName());
        Assertions.assertEquals(22000,employee.getSalary());
        Assertions.assertEquals(1,employee.getDepartment());
    }
    @Test
    public void shouldReturnEmployeeWithMinSalary(){
        Employee employee = departmentService.findEmployeeMinSalary(1);

        Assertions.assertEquals("Ivan",employee.getFirstName());
        Assertions.assertEquals("Ivanov",employee.getLastName());
        Assertions.assertEquals(2000,employee.getSalary());
        Assertions.assertEquals(1,employee.getDepartment());
    }

    }

