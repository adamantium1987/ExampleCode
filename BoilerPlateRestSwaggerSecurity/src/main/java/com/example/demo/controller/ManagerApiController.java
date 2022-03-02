package com.example.demo.controller;

import com.example.demo.model.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@SecurityRequirement(name="BoilerPlateAPI")
public class ManagerApiController implements UserApi {
    @Override
    public ResponseEntity<User> findById(long id) throws Exception {
        return null;
    }

    @Override
    public Collection<User> findUsers() {
        return null;
    }

    @Override
    public User updateUser(String id, User user) {
        return null;
    }

    @Override
    public User patchUser(String id, User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> postUser(User body) throws Exception {
        return null;
    }

    @Override
    public User getUserHeader() {
        return null;
    }

    @Override
    public long deleteUser(long id) throws Exception {
        return 0;
    }
}
