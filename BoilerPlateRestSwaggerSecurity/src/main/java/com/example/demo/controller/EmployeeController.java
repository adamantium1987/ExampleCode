package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Employee", description = "The Employee API")
@RequestMapping("/api/v1/employee/")
public class EmployeeController {

}
