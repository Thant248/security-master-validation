package com.example.securitymastervalidation.repository;

import com.example.securitymastervalidation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.DefaultEditorKit;
import java.util.Optional;

public interface CustomerDao  extends JpaRepository<Customer,Integer> {

}
