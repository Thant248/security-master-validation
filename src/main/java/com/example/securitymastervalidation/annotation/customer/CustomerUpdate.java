package com.example.securitymastervalidation.annotation.customer;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Secured(value = {"ROLE_SUPER_ADMIN"})
public @interface CustomerUpdate {
}
