package com.spring.begin.FirstSpringApp;

import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {

    @GetMapping("/hello")
    public HelloResponse hello(){
        return new HelloResponse("Welcome to SpringWorld");
    }

    @GetMapping("/users/{username}")
    public HelloResponse displayusername(@PathVariable String username){
        return new HelloResponse("Welcome " + username);
    }
    @PostMapping("/hello")//name is passed in the postman request
    public HelloResponse hellopostmsg(@RequestBody String name){
       return new HelloResponse("Hello " + name + "in post controller");
    }
}
