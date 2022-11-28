package com.gussoft.animegm.controller;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.models.Chapter;
import com.gussoft.animegm.models.mappers.AnimeMapper;
import com.gussoft.animegm.models.mappers.ChapterMapper;
import com.gussoft.animegm.service.ChapterService;
import com.gussoft.animegm.transfer.request.AnimeRequest;
import com.gussoft.animegm.transfer.request.ChapterRequest;
import com.gussoft.animegm.transfer.response.AnimeResponse;
import com.gussoft.animegm.transfer.response.ChapterResponse;
import com.gussoft.animegm.transfer.response.GenericResponse;
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
public class ChapterController {

    @Autowired
    private ChapterService service;

    @Autowired
    private ChapterMapper mapper;

    @GetMapping("/chapter/")
    public ResponseEntity<Page<Chapter>> listAll(
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

    @GetMapping("/chapter/{id}")
    public ResponseEntity<Chapter> listById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/chapter/")
    public ResponseEntity<ChapterResponse> save(@RequestBody ChapterRequest request) {
        return ResponseEntity.ok(mapper.toChapterResponse(service.saved(request)));
    }

    @PutMapping("/chapter/{id}")
    public ResponseEntity<ChapterResponse> update(
            @RequestBody ChapterRequest request,
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(mapper.toChapterResponse(service.updated(request, id)));
    }

    @DeleteMapping("/chapter/{id}")
    public ResponseEntity<GenericResponse> delete(
            @PathVariable(name = "id") long id) {
        service.deleted(id);
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

}
