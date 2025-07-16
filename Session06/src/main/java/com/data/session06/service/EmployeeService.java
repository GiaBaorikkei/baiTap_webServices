package com.data.session06.service;

import com.data.session06.model.entity.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
}

