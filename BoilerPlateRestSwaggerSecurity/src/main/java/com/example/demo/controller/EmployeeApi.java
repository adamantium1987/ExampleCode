package com.example.demo.controller;

import com.example.demo.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Tag(name = "employee", description = "the employee API")
@RequestMapping("/api/v1/employee")
public class EmployeeApi {
}