package com.example.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ems.entity.Employee;
import com.example.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = repository.findById(id).orElseThrow();
    
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setSalary(updatedEmployee.getSalary());
    
        return repository.save(employee);
    }
}

