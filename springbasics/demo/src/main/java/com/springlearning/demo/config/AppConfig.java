package com.springlearning.demo.config;

import com.springlearning.demo.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/* this class contains the spring configuration
Method return object as Bean */
@Configuration
public class AppConfig {
    @Bean
    public String appName(){
        return "Spring Learning Application";
    }
}
