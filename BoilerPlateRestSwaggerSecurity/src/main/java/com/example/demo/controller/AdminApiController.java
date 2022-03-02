package com.example.demo.controller;

import com.example.demo.model.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@SecurityRequirement(name="BoilerPlateAPI")
public class AdminApiController {
}
