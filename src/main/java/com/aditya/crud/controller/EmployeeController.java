package com.aditya.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.crud.model.Employee;
import com.aditya.crud.service.EmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
    
    @PutMapping("/{employeeCode}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "employeeCode") Long employeeCode, @RequestBody Employee employee) {        
        return new ResponseEntity<>(employeeService.updateEmployee(employeeCode, employee), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeCode}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "employeeCode") Long employeeCode){
        employeeService.deleteEmployee(employeeCode);
        return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
    }
    


}
