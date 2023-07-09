package com.example.hw052923.service;

import com.example.hw052923.Employee;

import java.util.Collection;

public interface EmployeeService    {


    Employee addEmployee(String firstName, String lastName, Integer department, Integer salary);


    Employee removeEmployee(String firstName, String lastName, Integer department, Integer salary);

    Employee findEmployee(String firstName, String lastName, Integer department, Integer salary);

    Collection<Employee> findAll();

    Collection<Employee> getAll();


    void addEmployee(Employee employee);
}
