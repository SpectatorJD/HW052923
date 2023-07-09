package com.example.hw052923.controller;

import com.example.hw052923.Employee;
import com.example.hw052923.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Employee addEmployee (@RequestParam Employee employee){
        return service.addEmployee(employee);
    }@GetMapping("/remove")
    public Employee removeEmployee (@RequestParam String firstName, String lastName){
        return service.removeEmployee(firstName,lastName);
    }@GetMapping("/find")
    public Employee findEmployee (@RequestParam String firstName, String lastName){
        return service.findEmployee(firstName,lastName);
    }
    @GetMapping
    public Collection<Employee> findAll(){
    return service.findAll();
    }




}
