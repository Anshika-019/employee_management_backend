package com.employee_management.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class EmployeeDTO {
     private Long id;
        private String name;
        private int age;
        private String empClass;
        private double attendance;
        private List<String> subjects;
}
