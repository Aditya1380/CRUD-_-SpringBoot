package com.aditya.crud.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aditya.crud.model.Employee;
import com.aditya.crud.repository.EmployeeRepository;
import com.aditya.crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee savedEmployee = new Employee();
        savedEmployee.setEmployeeName(employee.getEmployeeName());
        savedEmployee.setEmployeeDepartment(employee.getEmployeeDepartment());
        savedEmployee.setEmployeeCode(employee.getEmployeeCode());
        savedEmployee.setEmployeeEmail(employee.getEmployeeEmail());

        return employeeRepository.save(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeCode) {
        try {            
            employeeRepository.findByEmployeeCode(employeeCode);
        } catch (Exception e) {
            throw new RuntimeException("Unable to find Employee with this code :"+employeeCode);
        }
        employeeRepository.findByEmployeeCode(employeeCode);
    }

}
