package com.aditya.crud.service;

import java.util.List;

import com.aditya.crud.model.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Long id,Employee employee);
    void deleteEmployee(Long id);
}
