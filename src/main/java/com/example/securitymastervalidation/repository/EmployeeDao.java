package com.example.securitymastervalidation.repository;

import com.example.securitymastervalidation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
