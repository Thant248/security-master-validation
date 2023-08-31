package com.example.securitymastervalidation.repository;

import com.example.securitymastervalidation.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonDao extends JpaRepository<Person, Integer> {

    Optional<Person> findPersonByUserName(String userName);
}
