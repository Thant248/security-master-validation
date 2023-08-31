package com.example.securitymastervalidation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    private String userName;
    private String password;
    private String email;
    @Transient
    private String roleStName;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public Set<Role> roles = new HashSet<>();


    @Override
    public String toString() {
        return userName;
    }


}
