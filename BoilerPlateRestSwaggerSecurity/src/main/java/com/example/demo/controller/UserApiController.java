package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@RestController
@SecurityRequirement(name="BoilerPlateAPI")
@Tag(name = "user", description = "the User API")
@RequestMapping("/api/v1/user")
public class UserApiController{

    private final UserRepository repository;

    public UserApiController(UserRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity<User> findById(@PathVariable("id") final long id ) throws UserNotFoundException {
        return new ResponseEntity<>(repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found for this id: " + id)), HttpStatus.OK);
    }

    public ResponseEntity<Collection<User>> findUsers() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> updateOrCreateUser(@PathVariable("id") final long id, @RequestBody final User newUser) {
        return new ResponseEntity<>(repository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setUserName((newUser.getUserName()));
                    user.setEmail(newUser.getEmail());
                    user.setUserType(newUser.getUserType());
                    return (repository.save(user));
                })
                .orElseGet(() -> (repository.save(newUser))), HttpStatus.OK);
        }

    public ResponseEntity<User> createUser(@RequestBody final User user) {
        User newUser = new User();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setUserName((newUser.getUserName()));
        newUser.setUserType(user.getUserType());
        return new ResponseEntity<>(repository.save(newUser), HttpStatus.CREATED);
    }

    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable final long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deleteAllUsers(){
        repository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}