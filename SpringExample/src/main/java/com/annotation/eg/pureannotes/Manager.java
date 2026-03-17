package com.annotation.eg.pureannotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Manager {
    @Autowired//field autowiring making code written less
    @Qualifier("employee") // will only consider the class with name "employee" and type "Employee"
        private Employee employee;

    /*@Autowired
    public Manager(Employee employee) {
        this.employee = employee;
    }*/

    //This is constructor autowiring which gives more clarity

        @Override
        public String toString() {
            return "Manager{" +
                    "employee=" + employee +
                    '}';
        }
    }


