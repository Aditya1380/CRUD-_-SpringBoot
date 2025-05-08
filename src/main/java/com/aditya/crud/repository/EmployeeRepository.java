package com.aditya.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aditya.crud.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Employee findByEmployeeCode(Long employeeCode);
}
