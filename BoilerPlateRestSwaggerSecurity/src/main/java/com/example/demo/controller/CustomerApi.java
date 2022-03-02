package com.example.demo.controller;

import com.example.demo.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Tag(name = "customer", description = "the customer API")
@RequestMapping("/api/v1/customer")
public class CustomerApi {
}
