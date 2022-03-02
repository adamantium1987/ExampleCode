package com.example.demo.controller;

import java.util.Collection;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeApiController implements EmployeeApi {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public ResponseEntity<Employee> findById(
            long id,
            String EmployeeAuthorization) throws Exception {

        Employee Employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " + id));

        return ResponseEntity.ok().body(Employee);
    }

    @Override
    public Collection<Employee> findEmployees() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@PathVariable("id") final String id, @RequestBody final Employee Employee) {
        return Employee;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee patchEmployee(@PathVariable("id") final String id, @RequestBody final Employee Employee) {
        return Employee;
    }

    @Override
    public ResponseEntity<Employee> postEmployee(
            Employee body,
            String EmployeeAuthorization) throws Exception {
        return new ResponseEntity<Employee>(repository.save(body), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.HEAD, value = "/")
    @ResponseStatus(HttpStatus.OK)
    public Employee headEmployee() {
        return new Employee();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public long deleteEmployee(@PathVariable final long id) {
        return id;
    }
}
