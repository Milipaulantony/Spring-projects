package com.springtraining.FirstRestAPI.controller;

import com.springtraining.FirstRestAPI.model.HelloResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public HelloResponse hello(@PathVariable String name){
        return new HelloResponse("Hello " + name);
    }

    @PostMapping("/hello")
    public HelloResponse helloPost(@RequestBody String name) {
        return new HelloResponse("Hello " + name);
    }
}
