package com.example.securitymastervalidation.service;

import com.example.securitymastervalidation.entity.Person;
import com.example.securitymastervalidation.entity.Role;
import com.example.securitymastervalidation.repository.PersonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PersonService {

    @Autowired
    private PersonDao personDao;


    private final PasswordEncoder passwordEncoder;

    public List<Person> listAllPerson() {
        return personDao.findAll();
    }

    @Transactional
    public void savePerson(Person person) {

        Set<Role> roles = saveRoles(person.getRoleStName());
        for (Role ro : roles) {
            person.getRoles().add(ro);
        }
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personDao.save(person);
    }


    private Set<Role> saveRoles(String roleName) {
        if (roleName.contains(",")) {
            String[] role = roleName.split(",");
            return Stream.of(role).map(r -> {
                Role rol = new Role();
                rol.setName(r);
                return rol;
            }).collect(Collectors.toSet());
        } else {

            Role role = new Role();
            role.setName(roleName);
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            return roles;
        }
    }


}
