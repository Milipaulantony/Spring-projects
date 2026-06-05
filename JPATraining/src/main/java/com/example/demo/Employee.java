package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tcs_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Email
    private String email;

    // ===============================
    // OneToOne
    // ===============================
    @OneToOne(
            mappedBy = "employee_of_this_profile",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private EmployeeProfile emp_profile;

    // ===============================
    // OneToMany
    // ===============================
    @OneToMany(
            mappedBy = "employee_of_this_address",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();

    // ===============================
    // ManyToMany (Owner)
    // ===============================
   /* @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })*/
    @ManyToMany
    @JoinTable(
            name = "emp_connected_to_grp",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name="group_id")
    )
    private Set<EmployeeGroup> joined_groups = new HashSet<>();

    // ===============================
    // custom setter and getter methods
    // ===============================
    public void setProfile(EmployeeProfile profile) {
        this.emp_profile = profile;
        profile.setEmployee(this);

    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setEmployee(this);
    }

    public void addGroup(EmployeeGroup group) {
        joined_groups.add(group);
        //group.getEmployees().add(this);
        group.getEmployees_of_group().add(this);
    }

    // getters setters
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
