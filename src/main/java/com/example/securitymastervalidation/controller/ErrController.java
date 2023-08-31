package com.example.securitymastervalidation.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrController implements ErrorController {

    @GetMapping("/error")
    public String errorController(Model model){
        model.addAttribute("error", HttpStatus.FORBIDDEN.value());
        model.addAttribute("internal","an Internal Server Error");
        return "error";
    }
}
