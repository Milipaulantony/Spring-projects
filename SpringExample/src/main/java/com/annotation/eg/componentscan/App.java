package com.annotation.eg.componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("componentScanDemo.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.toString());
        //values are displayed because the employee object values are hardcoded
        Manager mgr = context.getBean(Manager.class);
        System.out.println(mgr.toString());
    }
}
