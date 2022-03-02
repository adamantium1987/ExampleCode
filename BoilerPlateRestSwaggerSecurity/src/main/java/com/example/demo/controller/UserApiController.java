package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@SecurityRequirement(name="BoilerPlateAPI")
public class UserApiController implements UserApi {

    private final UserRepository repository;

    public UserApiController(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<User> findById(long id ) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found for this id: " + id));
        return ResponseEntity.ok().body(user);
    }

    @Override
    public Collection<User> findUsers() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable("id") final String id, @RequestBody final User user) {
        return user;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User patchUser(@PathVariable("id") final String id, @RequestBody final User user) {
        return user;
    }

    @Override
    public ResponseEntity<User> postUser(User body ) {
        return new ResponseEntity<>(repository.save(body), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.HEAD, value = "/")
    @ResponseStatus(HttpStatus.OK)
    public User getUserHeader() {
        return new User();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public long deleteUser(@PathVariable final long id) throws Exception {
        try {
            repository.deleteById(id);
        }
        catch(Exception e){
            throw new UserNotFoundException("User not found for this id: " + id);
        }
        return id;
    }
}