package com.example.demo.controllers;

import com.example.demo.models.SocialUser;
import com.example.demo.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialService service_obj;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getAllUsers(){
        return new ResponseEntity<>(service_obj.findAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser user_info){
        return new ResponseEntity<>(service_obj.createUser(user_info),HttpStatus.CREATED);
    }
}
