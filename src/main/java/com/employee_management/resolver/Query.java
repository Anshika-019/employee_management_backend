package com.employee_management.resolver;

import com.employee_management.domain.Employee;
import com.employee_management.repo.EmployeeRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private final EmployeeRepository employeeRepository;

    GraphQLScalarType longScalar =
            ExtendedScalars.newAliasedScalar("Long")
                    .aliasedScalar(ExtendedScalars.GraphQLLong)
                    .build();

    @Autowired
    public Query(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public long countEmployees() {
        return employeeRepository.count();
    }
}
