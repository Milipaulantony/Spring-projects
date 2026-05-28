package com.springlearning.demo.service;


import org.springframework.stereotype.Service;

/* this annotation @Service tell spring container to create and manage this object(bean)
the object bean is of EmailService and stores it in IoC container
 */
@Service
public class EmailService implements MessageService{
    @Override
    public void sendMessage(String msg) {
        System.out.println("Email sent: " + msg);
    }
}
