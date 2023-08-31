package com.example.securitymastervalidation.service;

import com.example.securitymastervalidation.entity.Employee;
import com.example.securitymastervalidation.repository.EmployeeDao;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public List<Employee> findAllEmployee(){
        return employeeDao.findAll();
    }

    public void deleteById(int id){
        if (employeeDao.existsById(id)){
             employeeDao.deleteById(id);
        }
    }

    public Employee updateEmployee(Employee employee){

        return   employeeDao.saveAndFlush(employee);
    }
    public Employee findEmployeeById(int id){
        return employeeDao.findById(id).orElseThrow(()->new EntityNotFoundException("not found"));
    }






}
