package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "manager", description = "the Manager API")
@RequestMapping("/api/v1/manager")
public class ManagerApi {
}
