package com.example.securitymastervalidation.repository;

import com.example.securitymastervalidation.entity.Dapartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Dapartment,Integer> {
}
