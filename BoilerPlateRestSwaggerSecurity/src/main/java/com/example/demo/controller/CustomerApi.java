package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "customer", description = "the customer API")
@RequestMapping("/api/v1/customer")
public class CustomerApi {
}
