package com.example.securitymastervalidation.service;

import com.example.securitymastervalidation.entity.Customer;
import com.example.securitymastervalidation.repository.CustomerDao;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;

    private final PasswordEncoder passwordEncoder;

    public List<Customer> findAllCustomer(){
       return customerDao.findAll();
    }
    public Customer saveCustomer(Customer customer){
        return customerDao.save(customer);
    }
    public Customer findCustomerById(int id){
        return customerDao.findById(id).orElseThrow(()->new EntityNotFoundException("not found"));
    }
    public void deleteCustomerById(int id){
        if (customerDao.existsById(id)){
            customerDao.deleteById(id);
        }
    }

    public Customer updateCustomer(Customer customer){
        return customerDao.saveAndFlush(customer);
    }






}
