package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Manager", description = "The Manager API")
@RequestMapping("/api/v1/manager/")
public class ManagerController {

}
