package com.example.hw052923.service;

import com.example.hw052923.Employee;

import java.util.Collection;

public interface EmployeeService    {

    Employee addEmployee(Employee employee);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();

    Collection<Employee> getAll();

}
