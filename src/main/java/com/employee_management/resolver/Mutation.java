package com.employee_management.resolver;

import com.employee_management.domain.Employee;
import com.employee_management.repo.EmployeeRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private  EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(String name, int age, String empClass, List<String> subjects, double attendance) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setEmpClass(empClass);
        employee.setSubjects(subjects);
        employee.setAttendance(attendance);

        employeeRepository.save(employee);

        return employee;
    }

    public boolean deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }

    public Employee updateEmployee(Long id, String name, Integer age, String empClass, List<String> subjects, Double attendance) throws EntityNotFoundException {
        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            Employee employee = optEmployee.get();

            if (name != null) employee.setName(name);
            if (age != null) employee.setAge(age);
            if (empClass != null) employee.setEmpClass(empClass);
            if (subjects != null) employee.setSubjects(subjects);
            if (attendance != null) employee.setAttendance(attendance);

            employeeRepository.save(employee);
            return employee;
        }

        throw new EntityNotFoundException("Not found Employee to update!");
    }
}
