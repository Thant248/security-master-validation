package com.example.securitymastervalidation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @Override
    public String toString() {
        return name;
    }

    @PrePersist
    public void prePersist() {

        name = "ROLE_".concat(name);
    }

}
