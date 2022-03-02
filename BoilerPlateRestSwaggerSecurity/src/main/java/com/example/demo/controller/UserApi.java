package com.example.demo.controller;

import com.example.demo.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Tag(name = "user", description = "the User API")
@RequestMapping("/api/v1/user")
public interface UserApi {

    @Operation(summary = "Find User by ID", description = "Returns a single user", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<User> findById(
            @Parameter(description = "ID of User", required = true)
            @PathVariable long id)
            throws Exception;

    @Operation(summary = "Get All Users.", description = "Returns a users collection", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Collection<User> findUsers();

    @Operation(summary = "Update User.", description = "This can only be done by the logged in user.", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    User updateUser(@PathVariable("id") final String id, @RequestBody final User user);

    @Operation(summary = "Patch User.", description = "This can only be done by the logged in user.", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    User patchUser(@PathVariable("id") final String id, @RequestBody final User user);

    @Operation(summary = "Create User.", description = "This can only be done by the logged in user.", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)})
    @RequestMapping(value = "/", consumes = {  "application/json", "application/xml", "application/x-www-form-urlencoded"  }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<User> postUser(
            @NotNull
            @Parameter(description = "Created user object", required = true)
            @Valid @RequestBody User body)
            throws Exception;

    @Operation(summary = "Get header information for the user", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = User.class)))})
    @RequestMapping(value = "/", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.HEAD)
    @ResponseStatus(HttpStatus.OK)
    User getUserHeader();

    @Operation(summary = "Delete User.", description = "This can only be done by the logged in User.", tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/{id}", consumes = {  "application/json", "application/xml", "application/x-www-form-urlencoded"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    long deleteUser(@PathVariable final long id)
    throws Exception;
}