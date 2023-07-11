package com.example.hw052923;

import com.example.hw052923.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public final Employee findEmployeeMaxSalary(Integer department) {
        return  employeeService.getAll().stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .max(Comparator.comparingInt(e ->e.getSalary()))
                .orElseThrow(()-> new IllegalArgumentException("No employee in department"));

    }

    @Override
    public Employee findEmployeeMinSalary(Integer department) {
        return  employeeService.getAll().stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .min(Comparator.comparingInt(e ->e.getSalary()))
                .orElseThrow(()-> new IllegalArgumentException("No employee in department"));
    }

    @Override
    public Collection<Employee> getAllByDepartment(Integer department) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllGroupDepartment() {
        return employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(e->e.department));
    }
}
