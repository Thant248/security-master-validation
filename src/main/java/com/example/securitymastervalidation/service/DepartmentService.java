package com.example.securitymastervalidation.service;

import com.example.securitymastervalidation.entity.Dapartment;
import com.example.securitymastervalidation.repository.DepartmentDao;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentDao departmentDao;

    public List<Dapartment> listAllDepartment(){
        return departmentDao.findAll();
    }

    public Dapartment saveDepartment(Dapartment department){
        return departmentDao.save(department);
    }
    public void deleteById(int id){
        if (departmentDao.existsById(id)){
            departmentDao.deleteById(id);
        }
    }

    public Dapartment updateDepartment(Dapartment dapartment){
        return departmentDao.saveAndFlush(dapartment);
    }
    public Dapartment findDepartmentByid(int id){
        return departmentDao.findById(id).orElseThrow(()->new EntityNotFoundException("not found"));
    }

}
