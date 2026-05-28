package com.springlearning.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
Spring Container Starts
        ↓
Creates EmailService Bean
        ↓
Creates NotificationManager Bean
        ↓
Injects EmailService into NotificationManager
 */
@Component
public class NotificationManager {
    private MessageService messageService;

    @Autowired
    public NotificationManager(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(){
        messageService.sendMessage("Welcome to Spring Boot");
    }
}
