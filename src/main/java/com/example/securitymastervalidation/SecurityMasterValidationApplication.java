package com.example.securitymastervalidation;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityMasterValidationApplication {




    public static void main(String[] args) {
        SpringApplication.run(SecurityMasterValidationApplication.class, args);
    }

}
