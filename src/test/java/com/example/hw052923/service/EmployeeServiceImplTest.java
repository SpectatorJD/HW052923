package com.example.hw052923.service;

import com.example.hw052923.Employee;
import com.example.hw052923.exception.exception.EmployeeAlreadyAddedException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceImplTest {
    private EmployeeService employeeService = new EmployeeServiceImpl();
@Test
    public void shouldAddEmployeeWhenNotExists(){
        Employee employee = new Employee("Ivan", "Petrov", 1500,1);
        employeeService.addEmployee(employee);
        Employee createNewEmployee = employeeService.find("Ivan", "Petrov", 1, 1500);
        Assertions.assertEquals(employee, createNewEmployee);
    }
    @Test
    public void shouldThrowExceptionWhenAddExisted(){
        Employee employee = new Employee("Ivan", "Petrov", 1500,1);
        employeeService.addEmployee(employee);

        Assertions.assertThrows(EmployeeAlreadyAddedException.class, ()-> employeeService.add("Petrov", "Ivan",2,1500));
    }


}
