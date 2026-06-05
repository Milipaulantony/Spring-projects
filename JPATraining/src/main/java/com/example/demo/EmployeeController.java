package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee create(
            @Valid @RequestBody Employee employee) {

        return service.create(employee);
    }

    @GetMapping("/{id}")
    public Employee get(
            @PathVariable Long id) {

        return service.getEmployee(id);
    }

    @GetMapping("/")
    public List<Employee>  getAll() {

        return service.getAll();
    }

    @PutMapping("/{id}")
    public Employee update(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {

        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }
}
