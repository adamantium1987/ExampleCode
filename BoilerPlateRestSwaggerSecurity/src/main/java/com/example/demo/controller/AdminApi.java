package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "admin", description = "the admin API")
@RequestMapping("/api/v1/admin")
public class AdminApi {
}
