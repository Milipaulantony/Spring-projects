package com.basic.securitydemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrController {
    @PostMapping("/create")
    public String createEmployee() {
        return "HR created employee";
    }
}
