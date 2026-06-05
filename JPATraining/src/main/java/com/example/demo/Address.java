package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tcs_emp_addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String city;

    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id_address_class")
    @JsonIgnore
    private Employee employee_of_this_address;

    // getters setters

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //public Employee getEmployee() { return employee_of_this_address;}

    public void setEmployee(Employee employee) {
        this.employee_of_this_address = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
