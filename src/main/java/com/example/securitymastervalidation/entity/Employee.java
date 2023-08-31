package com.example.securitymastervalidation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotEmpty(message = "firstName cannot be blank")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "lastName cannot be empty")
    private String lastName;

    @Column(name = "phone_number")
    @NotEmpty(message = "phoneNumber cannot be empty")
    private String phoneNumber;
    @Column(name = "address")
    @NotEmpty(message = "address cannot be empty")
    private String address;
    @Column(name = "cubicle_np")
    @NotEmpty(message = "cubicle cannot be empty")
    private String cubicleNumber;


}
