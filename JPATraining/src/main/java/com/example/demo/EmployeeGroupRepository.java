package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeGroupRepository
        extends JpaRepository<EmployeeGroup, Long> {
}
