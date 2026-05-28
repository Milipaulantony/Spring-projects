package com.springlearning.demo;


/*
                 SPRING CONTAINER
 -------------------------------------------------
 |                                               |
 |  EmailService Bean                            |
 |  NotificationManager Bean                     |
 |  LoggingAspect Bean                           |
 |  HelloController Bean                         |
 |  StartupRunner Bean                           |
 |                                               |
 -------------------------------------------------
          ↓             ↓
      Dependency     AOP Proxy
       Injection
 */

/* Overall flowchart of this training program

Application Starts
        ↓
Spring Container Created
        ↓
Component Scan Happens
        ↓
Beans Created
        ↓
Dependencies Injected
        ↓
AOP Proxies Created
        ↓
Application Ready
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*The annotation @SpringBootApplication combines
@Configuration
@EnableAutoConfiguration
@ComponentScan
Creates the container, scan beans, autoconfigure application
 */



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Spring Boot Application started");
	}

}
/* For health stats where we have added in application.properties file
http://localhost:8080/actuator/health
| Endpoint             | Purpose          |
| -------------------- | ---------------- |
| `/actuator/health`   | App health       |
| `/actuator/beans`    | All Spring Beans |
| `/actuator/env`      | Environment      |
| `/actuator/mappings` | API mappings     |

 */