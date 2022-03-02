package com.example.demo.controller;

import com.example.demo.model.Model;
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

@Tag(name = "model", description = "the model API")
@RequestMapping("/api/v1/models")
public interface ModelApi {

    @Operation(summary = "Find model by ID", description = "Returns a single model", tags = { "model" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Model.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Model> findById(
            @Parameter(description = "ID of model", required = true)
            @PathVariable long id)
            throws Exception;

    @Operation(summary = "Get All Models.", description = "Returns a models collection", tags = { "model" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Model.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Collection<Model> findModels();

    @Operation(summary = "Update Model.", description = "This can only be done by the logged in model.", tags = { "model" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Model.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    Model updateModel(@PathVariable("id") final String id, @RequestBody final Model model);

    @Operation(summary = "Patch Model.", description = "This can only be done by the logged in model.", tags = { "model" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Model.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    Model patchModel(@PathVariable("id") final String id, @RequestBody final Model model);

    @Operation(summary = "Create Model.", description = "This can only be done by the logged in model.", tags = { "model" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Model.class)), @Content(mediaType = "application/xml", schema = @Schema(implementation = Model.class)) }),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)})
    @RequestMapping(value = "/", consumes = {  "application/json", "application/xml", "application/x-www-form-urlencoded"  }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Model> postModel(
            @NotNull
            @Parameter(description = "Created model object", required = true)
            @Valid @RequestBody Model body)
            throws Exception;

    @Operation(summary = "Get header information for the model", tags = { "model" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Model.class)))})
    @RequestMapping(value = "/", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.HEAD)
    @ResponseStatus(HttpStatus.OK)
    Model headModel();

    @Operation(summary = "Delete Model.", description = "This can only be done by the logged in model.", tags = { "model" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Model.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "model not found", content = @Content) })
    @RequestMapping(value = "/{id}", consumes = {  "application/json", "application/xml", "application/x-www-form-urlencoded"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    long deleteModel(@PathVariable final long id)
    throws Exception;
}