package com.employee_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementBackendApplication.class, args);
		System.out.println("Employee Management Backend Application Started Successfully");
	}

}
