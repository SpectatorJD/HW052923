package com.example.hw052923.service;

import com.example.hw052923.Employee;
import com.example.hw052923.exception.exception.EmployeeAlreadyAddedException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceImplTest {
    private EmployeeService employeeService = new EmployeeServiceImpl() {
        @Override
        public void addEmployee(Employee employee) {

        }
    };
@Test
    public void shouldAddEmployeeWhenNotExists(){
        Employee employee = new Employee("Ivan", "Ivanov", 1000,1);
        employeeService.add(employee);

        Employee createdNewEmployee = employeeService.findEmployee("Ivan", "Ivanov",1,1000);
        Assertions.assertEquals(employee, createdNewEmployee);
    }
    @Test
    public void shouldThrowExceptionWhenAddExisted(){
        Employee employee = new Employee("Ivan", "Petrov", 1000,1);
        employeeService.addEmployee(employee);

        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee(employee));
    }


}
