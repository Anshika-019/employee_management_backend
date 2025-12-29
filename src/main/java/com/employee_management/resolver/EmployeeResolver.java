package com.employee_management.resolver;

import com.employee_management.domain.Employee;
import com.employee_management.repo.EmployeeRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@RequiredArgsConstructor
public class EmployeeResolver implements GraphQLResolver<Employee> {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeResolver(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> listEmployees(String name, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable).getContent();
    }

    public Employee employeeDetails(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setEmpClass(employee.getEmpClass());
        existingEmployee.setSubjects(employee.getSubjects());
        existingEmployee.setAttendance(employee.getAttendance());
        return employeeRepository.save(existingEmployee);
    }

    public boolean deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(existingEmployee);
        return true;
    }
}