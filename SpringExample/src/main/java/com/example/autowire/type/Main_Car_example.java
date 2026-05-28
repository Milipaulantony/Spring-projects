package com.example.autowire.type;

import car.example.constructor.injection.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_Car_example {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("autowireBytypecontext.xml");
        car.example.constructor.injection.Car myCar = (Car)context.getBean("MyCar");
        myCar.displayDetails();
    }
}
