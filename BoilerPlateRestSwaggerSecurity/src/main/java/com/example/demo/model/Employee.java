package com.example.demo.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Schema(description = "Employee object")
@Entity
@Table(name="employees")
public class Employee {

    @JsonProperty(value="empId", required=true)
    @Schema(description = "Unique identifier of the Employee.",
            example = "000001", required = true)
    private String empId;

    @JsonProperty(value="name", required=true)
    @Schema(description = "First and Last Name of the Employee.",
            example = "John Doe, Jane Doe", required = true)
    @NotBlank
    @Size(min = 0)
    private String name;
    private String designation;
    private double salary;

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Column(name = "Employee_Name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
