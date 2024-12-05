package com.employee_management.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "age")
//    private int age;
//
//    @Column(name = "empClass")
//    private String empClass;
//
//    @Column(name = "subjects")
//    @ElementCollection
//    private List<String> subjects;
//
//    @Column(name = "attendance")
//    private double attendance;

        @Id
        private Long id;
        private String name;
        private int age;
        private String empClass;
        private List<String> subjects;
        private double attendance;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmpClass() {
            return empClass;
        }

        public void setEmpClass(String empClass) {
            this.empClass = empClass;
        }

        public List<String> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<String> subjects) {
            this.subjects = subjects;
        }

        public double getAttendance() {
            return attendance;
        }

        public void setAttendance(double attendance) {
            this.attendance = attendance;
        }


}
