package com.example.demo.controller;

import java.util.Collection;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SecurityRequirement(name = "BoilerPlateAPI")
@Tag(name = "Employee", description = "the Employee API")
@RequestMapping("/api/v1/Employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @Operation(summary = "Find Employee by ID.", description = "Returns a single Employee", tags = { "Employee" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Employee.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> findById(String EmployeeAuthorization, @PathVariable long id) throws Exception {
        Employee Employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(Employee);
    }

    @Operation(summary = "Get All Employees.", description = "Returns a Employees collection", tags = { "Employee" })
    @RequestMapping(value = "/" ,  produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Employee> findEmployees() {
        return repository.findAll();
    }

    @Operation(summary = "Update Employee by ID.", description = "This can only be done by the logged in Employee.", tags = { "Employee" })
    @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Employee.class)) }) })
    @RequestMapping(value = "/{id}" ,  produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable("id") final long id, @RequestBody final Employee Employee) {
        return Employee;
    }

    @Operation(summary = "Delete Employee by ID.", description = "This can only be done by the logged in Employee.", tags = { "Employee" })
    @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Employee.class)) }) })
    @RequestMapping(value = "/" ,  produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public long deleteEmployee(@PathVariable final long id) {
        return id;
    }
}
