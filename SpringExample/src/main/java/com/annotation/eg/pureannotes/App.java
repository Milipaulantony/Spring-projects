package com.annotation.eg.pureannotes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.toString());
        //values are displayed because the employee object values are hardcoded
        Manager mgr = context.getBean(Manager.class);
        System.out.println(mgr.toString());
    }
}
