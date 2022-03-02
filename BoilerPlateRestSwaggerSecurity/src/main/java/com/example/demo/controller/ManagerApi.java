package com.example.demo.controller;

import com.example.demo.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Tag(name = "manager", description = "the Manager API")
@RequestMapping("/api/v1/manager")
public class ManagerApi {
}
