package com.example.hw052923.service;

import com.example.hw052923.Employee;

import java.util.Collection;

public interface EmployeeService    {


    Employee add(String firstName, String lastName);

    Employee add(String firstName, String lastName, Integer department, Integer salary);

    Employee addEmployee(String firstName, String lastName, Integer department, Integer salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);


    Employee remove(String firstName, String lastName, Integer department, Integer salary);

    Employee findEmployee(String firstName, String lastName, Integer department, Integer salary);

    Employee find(String firstName, String lastName, Integer department, Integer salary);

    Collection<Employee> findAll();

    Collection<Employee> getAll();


    void add(Employee employee);

    void addEmployee(Employee employee);
}
