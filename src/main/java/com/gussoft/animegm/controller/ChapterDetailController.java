package com.gussoft.animegm.controller;

import com.gussoft.animegm.models.mappers.ChapterDetailMapper;
import com.gussoft.animegm.service.ChapterDetailService;
import com.gussoft.animegm.transfer.request.ChapterDetailRequest;
import com.gussoft.animegm.transfer.response.ChapterDetailResponse;
import com.gussoft.animegm.transfer.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
@Slf4j
public class ChapterDetailController {

    @Autowired
    private ChapterDetailService service;

    @Autowired
    private ChapterDetailMapper mapper;

    @GetMapping("/chapter/detail/{id}")
    public ResponseEntity<ChapterDetailResponse> listById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(mapper.toChapterDetailResponse(service.findById(id)));
    }

    @PostMapping("/chapter/{id}/detail/")
    public ResponseEntity<GenericResponse> save(
            @RequestBody ChapterDetailRequest request,
            @PathVariable(name = "id") long id) {
        ChapterDetailResponse response = mapper.toChapterDetailResponse(service.saved(request, id));
        log.info("Detail Create : " + response.getId());
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

    @PutMapping("/chapter/detail/{id}")
    public ResponseEntity<ChapterDetailResponse> update(
            @RequestBody ChapterDetailRequest request,
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(mapper.toChapterDetailResponse(service.updated(request, id)));
    }

    @DeleteMapping("/chapter/detail/{id}")
    public ResponseEntity<GenericResponse> delete(
            @PathVariable(name = "id") long id) {
        service.deleted(id);
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

}
