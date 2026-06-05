package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tcs_emp_profiles")
public class EmployeeProfile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String designation;

        private Double salary;

        @OneToOne
        @JoinColumn(name = "emp_id_profile_class")
        @JsonIgnore
        private Employee employee_of_this_profile;

        // Getters/Setters

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        //public Employee getEmployee() {return employee_of_this_profile;        }

        public void setEmployee(Employee employee) {
            this.employee_of_this_profile = employee;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }


}
