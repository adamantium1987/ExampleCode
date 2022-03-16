package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/api/v1/user")
public interface UserApi {

    @RequestMapping(value = "/{id}", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<User> findById(@PathVariable long id)throws Exception;

    @RequestMapping(value = "/", produces = { "application/json",  "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Collection<User> findUsers();

    @RequestMapping(value = "/{id}", consumes = {  "application/json", "application/xml", "application/x-www-form-urlencoded"  }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<User> updateUser(
            @PathVariable long id, @RequestBody final User newUser)
            throws Exception;

    @RequestMapping(value = "/", consumes = {  "application/json", "application/xml", "application/x-www-form-urlencoded"  }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<User> createUser(
            @RequestBody final User newUser)
            throws Exception;

    @RequestMapping(value = "/{id}", consumes = {  "application/json", "application/xml", "application/x-www-form-urlencoded"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<HttpStatus> deleteUser(@PathVariable final long id)
    throws Exception;
}
