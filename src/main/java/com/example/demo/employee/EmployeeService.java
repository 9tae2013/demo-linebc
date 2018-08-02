package com.example.demo.employee;

import com.example.demo.domain.Department;
import com.example.demo.domain.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Employee createEmployee(Employee employee, Long depId) {
        Department department = departmentRepository.getOne(depId);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void changeDepartment(Long empId, Long depId) {
        Optional<Employee> optEmployee = employeeRepository.findById(empId);
        if (optEmployee.isPresent()) {
            Employee employee = optEmployee.get();
            Department department = departmentRepository.getOne(depId);
            employee.setDepartment(department);
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.delete(employeeRepository.getOne(id));
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(Long empId) {
        return employeeRepository.findById(empId);
    }

    public List<Employee> getByDepId(Long depId) {
        return employeeRepository.findByDepartmentId(depId);
    }
}
