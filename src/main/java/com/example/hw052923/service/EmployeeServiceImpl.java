package com.example.hw052923.service;

import com.example.hw052923.Employee;
import com.example.hw052923.exception.EmployeeNotFoundException;
import com.example.hw052923.exception.exception.EmployeeAlreadyAddedException;
import com.example.hw052923.exception.exception.InvalidateInputException;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public  class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> storage = new HashMap<>();


    @Override
    public Employee addEmployee(Employee employee) {
        if (storage.containsKey(employee.getFirstName() + employee.getLastName())) {
            throw new EmployeeAlreadyAddedException();
        }
        storage.put(employee.getFirstName() + employee.getLastName(), employee);

        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {


        if (!storage.containsKey(firstName + lastName)) {
           throw new EmployeeNotFoundException();

        }
        storage.remove(firstName+lastName);
        return null;
    }



    @Override
    public Employee findEmployee(String firstName, String lastName) {


        if (!storage.containsKey(firstName + lastName)) {
           throw new EmployeeNotFoundException();
        }
        return storage.get(firstName + lastName);
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }


    @Override
    public Collection<Employee> getAll() {
        return null;
    }


    private void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidateInputException();
        }
    }
}
