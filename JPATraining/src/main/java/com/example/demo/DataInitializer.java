package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {


    private final EmployeeRepository employeeRepository;
    private final EmployeeGroupRepository employeeGroupRepository;

    public DataInitializer(EmployeeRepository employeeRepository, EmployeeGroupRepository employeeGroupRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeGroupRepository = employeeGroupRepository;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {

            EmployeeGroup admin = new EmployeeGroup();
            admin.setGroupName("ADMIN");

            EmployeeGroup developer = new EmployeeGroup();
            developer.setGroupName("DEVELOPER");

            EmployeeGroup tester = new EmployeeGroup();
            tester.setGroupName("TESTER");

            employeeGroupRepository.save(admin);
            employeeGroupRepository.save(developer);
            employeeGroupRepository.save(tester);
            // =================================
            // Employee 1
            // =================================

            System.out.println("*****Employee 1 initialized******");
            Employee emp1 = new Employee();
            emp1.setName("John");
            emp1.setEmail("john@test.com");

            EmployeeProfile p1 = new EmployeeProfile();
            p1.setDesignation("Senior Developer");
            p1.setSalary(120000.0);

            emp1.setProfile(p1);

            emp1.addAddress(createAddress("Dallas", "Texas"));
            emp1.addAddress(createAddress("Austin", "Texas"));

            emp1.addGroup(admin);
            emp1.addGroup(developer);

            System.out.println("*****Employee 1 details in object emp1******");
            employeeRepository.save(emp1);
            System.out.println("*****Employee 1 details inserted in DB******");
            // =================================
            // Employee 2
            // =================================

            System.out.println("*****Employee 2 initialized******");

            Employee emp2 = new Employee();
            emp2.setName("Mary");
            emp2.setEmail("mary@test.com");

            EmployeeProfile p2 = new EmployeeProfile();
            p2.setDesignation("QA Lead");
            p2.setSalary(100000.0);

            emp2.setProfile(p2);

            emp2.addAddress(createAddress("Raleigh","North Carolina"));

            emp2.addGroup(tester);

            System.out.println("*****Employee 2 details in object emp2******");
            employeeRepository.save(emp2);
            System.out.println("*****Employee 2 details inserted in DB******");
            // =================================
            // Employee 3
            // =================================

            System.out.println("*****Employee 3 initialized******");
            Employee emp3 = new Employee();
            emp3.setName("David");
            emp3.setEmail("david@test.com");

            EmployeeProfile p3 = new EmployeeProfile();
            p3.setDesignation("Architect");
            p3.setSalary(150000.0);

            emp3.setProfile(p3);

            emp3.addAddress(createAddress("Charlotte","North Carolina"));
            emp3.addAddress(createAddress("Atlanta","Georgia"));

            emp3.addGroup(admin);
            emp3.addGroup(developer);
            emp3.addGroup(tester);

            System.out.println("*****Employee 3 details in object emp3******");
            employeeRepository.save(emp3);
            System.out.println("*****Employee 2 details inserted in DB******");
        };

    }

    private Address createAddress(
                        String city, String state) {
        Address address = new Address();

        address.setCity(city);
        address.setState(state);

        return address;
    }

}
