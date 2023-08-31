package com.example.securitymastervalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home {

    @GetMapping(value = {"/","/home"})
    public String home(){
        return "home";
    }
}
