package com.example.securitymastervalidation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private  String address;



}

