package com.example.securitymastervalidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dapartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int code;
    private String name;
    private String country;
}
