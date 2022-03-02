package com.example.demo.controller;

import com.example.demo.exception.ModelNotFoundException;
import com.example.demo.model.Model;
import com.example.demo.repository.ModelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ModelApiController implements ModelApi {

    private final ModelRepository repository;

    public ModelApiController(ModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Model> findById(
            long id,
            String modelAuthorization) throws Exception {

        Model model = repository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Model not found for this id :: " + id));

        return ResponseEntity.ok().body(model);
    }

    @Override
    public Collection<Model> findModels() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Model updateModel(@PathVariable("id") final String id, @RequestBody final Model
            model
    ) {
        return model;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Model patchModel(@PathVariable("id") final String id, @RequestBody final Model
            model
    ) {
        return model;
    }

    @Override
    public ResponseEntity<Model> postModel(
            Model body,
            String modelAuthorization) {
        return new ResponseEntity<>(repository.save(body), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.HEAD, value = "/")
    @ResponseStatus(HttpStatus.OK)
    public Model headModel() {
        return new Model();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public long deleteModel(@PathVariable final long id) {
        return id;
    }
}