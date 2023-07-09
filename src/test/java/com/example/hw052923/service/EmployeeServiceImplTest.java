package com.example.hw052923.service;


import com.example.hw052923.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceImplTest {

    private EmployeeService employeeService = new EmployeeServiceImpl();


    @Test
    public void shouldAddEmployeeWhenNotExists(){
        Employee employee = new Employee("Ivan", "Ivanov", 1,1000);
        employeeService.addEmployee(employee);


        Employee createdNewEmployee = employeeService.findEmployee("Ivan", "Ivanov");
        Assertions.assertEquals(employee, createdNewEmployee);
    }


}
