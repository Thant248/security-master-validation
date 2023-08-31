package com.example.securitymastervalidation.controller;

import com.example.securitymastervalidation.entity.Person;
import com.example.securitymastervalidation.service.PersonService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;


    @GetMapping("/signUp")
    public String createPerson(Model model) {
        model.addAttribute("person", new Person());
        return "signUp";
    }

    @PostMapping("/save")
    public String savePerson(Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "signUp";
        }
        personService.savePerson(person);
        return "redirect:/login";
    }


    @GetMapping("/list")
    @RolesAllowed(value = {"SUPER_ADMIN"})
    public String listPerson(Model model) {
        model.addAttribute("persons", personService.listAllPerson());
        return "persons";
    }


    @GetMapping("/login-error")
    public String loginError(Model model) {

        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
