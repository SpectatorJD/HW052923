package com.example.hw052923;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeMaxSalary (Integer department);
    Employee findEmployeeMinSalary (Integer department);
    Collection<Employee> getAllByDepartment (Integer department);
    Map<Integer, List<Employee>> getAllGroupDepartment();

}
