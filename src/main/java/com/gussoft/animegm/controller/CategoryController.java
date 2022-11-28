package com.gussoft.animegm.controller;

import com.gussoft.animegm.models.mappers.CategoryMapper;
import com.gussoft.animegm.service.CategoryService;
import com.gussoft.animegm.transfer.request.CategoryRequest;
import com.gussoft.animegm.transfer.response.CategoryResponse;
import com.gussoft.animegm.transfer.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService service;
    @Autowired
    private CategoryMapper mapper;

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryResponse> listById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(mapper.toCategoryResponse(service.findById(id)));
    }

    @PostMapping("/category/")
    public ResponseEntity<CategoryResponse> save(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(mapper.toCategoryResponse(service.saved(request.getName())));
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryResponse> update(
            @RequestBody CategoryRequest request,
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(mapper.toCategoryResponse(service.updated(request.getName(), id)));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<GenericResponse> delete(
            @PathVariable(name = "id") long id) {
        service.deleted(id);
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

}
