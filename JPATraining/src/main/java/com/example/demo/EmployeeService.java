package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee create(Employee employee) {

        repository.findByEmail(employee.getEmail())
                .ifPresent(e -> {
                    throw new DuplicateEmployeeException(
                            "Email already exists");
                });

        return repository.save(employee);
    }

    public Employee getEmployee(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found"));
    }

    public Employee update(Long id,
                           Employee updated) {

        Employee employee = getEmployee(id);

        employee.setName(updated.getName());
        employee.setEmail(updated.getEmail());

        return repository.save(employee);
    }

    public void delete(Long id) {

        Employee employee = getEmployee(id);

        repository.delete(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }
}
