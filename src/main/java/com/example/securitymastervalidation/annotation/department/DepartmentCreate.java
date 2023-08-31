package com.example.securitymastervalidation.annotation.department;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@RolesAllowed(value = {"DEPARTMENT_PAGE_VIEW",
        "DEPARTMENT_READ",
        "DEPARTMENT_CREATE","SUPER_ADMIN"})
public @interface DepartmentCreate {
}
