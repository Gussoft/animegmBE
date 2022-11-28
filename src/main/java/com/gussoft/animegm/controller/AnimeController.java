package com.gussoft.animegm.controller;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.models.mappers.AnimeMapper;
import com.gussoft.animegm.service.AnimeService;
import com.gussoft.animegm.transfer.request.AnimeRequest;
import com.gussoft.animegm.transfer.request.CategoryRequest;
import com.gussoft.animegm.transfer.response.AnimeResponse;
import com.gussoft.animegm.transfer.response.GenericResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class AnimeController {

    @Autowired
    private AnimeService service;

    @Autowired
    private AnimeMapper mapper;

    @GetMapping("/anime/")
    public ResponseEntity<Page<Anime>> listAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "order", defaultValue = "name") String order,
            @RequestParam(name = "acs", defaultValue = "true") boolean asc) {
        Pageable pageRequest = PageRequest.of(page, size, Sort.by(order));
        if (!asc) {
            pageRequest = PageRequest.of(page, size, Sort.by(order).descending());
        }
        return ResponseEntity.ok(service.listAllPages(pageRequest));
    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<Anime> listById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/anime/")
    public ResponseEntity<AnimeResponse> save(@RequestBody AnimeRequest anime) {
        return ResponseEntity.ok(mapper.toAnimeResponse(service.saved(anime)));
    }

    @PutMapping("/anime/{id}")
    public ResponseEntity<AnimeResponse> update(
            @RequestBody AnimeRequest request,
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(mapper.toAnimeResponse(service.updated(request, id)));
    }

    @PutMapping("/anime/{id}/category")
    public ResponseEntity<GenericResponse> updateCategory(
            @RequestBody List<CategoryRequest> request,
            @PathVariable(name = "id") long id) {
        service.updateCategory(id, request);
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

    @DeleteMapping("/anime/{id}")
    public ResponseEntity<GenericResponse> delete(
            @PathVariable(name = "id") long id) {
        service.deleted(id);
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

}
