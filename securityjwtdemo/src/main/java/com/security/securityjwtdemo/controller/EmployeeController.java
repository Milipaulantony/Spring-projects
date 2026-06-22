package com.security.securityjwtdemo.controller;

import com.security.securityjwtdemo.dtos.LoginRequest;
import com.security.securityjwtdemo.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

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

    @PostMapping("/auth/login")
    public String login(
            @RequestBody LoginRequest request) {
        logger.info("*****JWTINFO******::Login request: " + request);
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        ));
        logger.info("*****JWTINFO******::Authentication is done");
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(
                    request.getUsername());
        }

        return "Invalid credentials";
    }
}

