package com.example.hw052923.controller;

import com.example.hw052923.DepartmentService;
import com.example.hw052923.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/depatrment")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController ( DepartmentService departmentService){
        this.departmentService= departmentService;
    }
    @GetMapping("/max-salary")
    public Employee findWithMaxSalary (@RequestParam("department") Integer department){
        return departmentService.findEmployeeMaxSalary(department);

    }
    @GetMapping("/min-salary")
    public Employee findWithMinSalary (@RequestParam("department") Integer department){
        return departmentService.findEmployeeMinSalary(department);
    }
    @GetMapping(value = "/all", params = "department")
    public Collection<Employee> getAllByDepartment(@RequestParam("department") Integer department){
return departmentService.getAllByDepartment(department);

    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getGroupByDepartment(){
        return departmentService.getAllGroupDepartment();
    }
}
