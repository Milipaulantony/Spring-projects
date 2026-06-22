package com.basic.securitydemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    @GetMapping("/whoami")
    public String whoAmI() {

        Authentication auth =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        return "Logged in user: " + auth.getName();
    }

    @GetMapping("/details")
    public String employeeDetails() {
        return "Employee details visible";
    }
}
