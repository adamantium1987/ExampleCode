package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "employee", description = "the employee API")
@RequestMapping("/api/v1/employee")
public class EmployeeApi {
}
