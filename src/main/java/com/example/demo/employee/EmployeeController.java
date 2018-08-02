package com.example.demo.employee;

import com.example.demo.domain.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/dep/{depId}")
    public List<Employee> getEmployeeByDep(@PathVariable Long depId) {
        return service.getByDepId(depId);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/dep/{depId}")
    public Employee create(@RequestBody Employee employee, @PathVariable Long depId) {
        return service.createEmployee(employee, depId);
    }
}
