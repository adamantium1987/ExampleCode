package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UserApiController implements UserApi {

    private final UserRepository repository;

    public UserApiController(UserRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<User> findById(long id) throws UserNotFoundException {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found for this id: " + id));
        return ResponseEntity.ok().body(user);
    }

    public Collection<User> findUsers() {
        return repository.findAll();
    }

    public ResponseEntity<User> createUser(@RequestBody final User newUser) {
        return new ResponseEntity<>(repository.save(newUser), HttpStatus.CREATED);
    }
    public ResponseEntity<User> updateUser(@PathVariable("id") final long id, @RequestBody final User newUser) {
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable final long id) throws UserNotFoundException {
        try {
            repository.deleteById(id);
        }
        catch(Exception e){
            throw new UserNotFoundException("User not found for this id: " + id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}