package com.example.demo.controller;

import com.example.demo.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;


@RestController
@SecurityRequirement(name = "BoilerPlateAPI")
@Tag(name = "Employee", description = "the Employee API")
@RequestMapping("/api/v1/Employees")
public interface EmployeeApi {

    @Operation(summary = "Find Employee by ID", description = "Returns a single Employee", tags = { "Employee" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Employee.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> findById(
            @Parameter(description = "ID of Employee", required = true)
            @PathVariable long id,
            @NotNull @Parameter(description = "select which kind of data to fetch", required = true)
            @Valid @RequestHeader(value="EmployeeAuthorization", required = true) String EmployeeAuthorization)
            throws Exception;

    @Operation(summary = "Get Employees", description = "Returns a Employees collection", tags = { "Employee" })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Employee> findEmployees();

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable("id") final String id, @RequestBody final Employee Employee);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee patchEmployee(@PathVariable("id") final String id, @RequestBody final Employee Employee);

    @Operation(summary = "Create Employee", description = "This can only be done by the logged in Employee.", tags = { "Employee" })
    @ApiResponses(value = { @ApiResponse(description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Employee.class)) }) })
    @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> postEmployee(
            @NotNull
            @Parameter(description = "Created Employee object", required = true)
            @Valid @RequestBody Employee body,
            @NotNull @Parameter(description = "select which kind of data to fetch", required = true)
            @Valid @RequestHeader(value="EmployeeAuthorization", required = true) String EmployeeAuthorization)
            throws Exception;

    @RequestMapping(method = RequestMethod.HEAD, value = "/")
    @ResponseStatus(HttpStatus.OK)
    public Employee headEmployee();

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public long deleteEmployee(@PathVariable final long id);

}