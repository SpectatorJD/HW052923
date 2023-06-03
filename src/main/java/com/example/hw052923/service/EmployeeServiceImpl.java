package com.example.hw052923.service;

import com.example.hw052923.Employee;
import com.example.hw052923.exception.EmployeeNotFoundException;
import com.example.hw052923.exception.exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee add(String firstName, String lastName, Integer department, Integer salary) {
        Employee employee = new Employee( firstName, lastName, department, salary);
        if(employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee remove(String firstName, String lastName, Integer department, Integer salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if(employees.containsKey(employee.getFullName())){
            return employees.remove(employee.getFullName());

        }
       throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, Integer department, Integer salary) {
        Employee employee= new Employee(firstName, lastName, department, salary);
        if(employees.containsKey(employee.getFullName())){
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Collection<Employee> getAll() {
        return null;
    }
}
