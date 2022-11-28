package com.gussoft.animegm.controller;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.models.Chapter;
import com.gussoft.animegm.models.Premiere;
import com.gussoft.animegm.models.mappers.AnimeMapper;
import com.gussoft.animegm.models.mappers.PremiereMapper;
import com.gussoft.animegm.service.AnimeService;
import com.gussoft.animegm.service.ChapterService;
import com.gussoft.animegm.service.PremiereService;
import com.gussoft.animegm.transfer.request.PremiereRequest;
import com.gussoft.animegm.transfer.response.AnimeResponse;
import com.gussoft.animegm.transfer.response.GenericResponse;
import com.gussoft.animegm.transfer.response.PremiereGenericResponse;
import com.gussoft.animegm.transfer.response.PremiereResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class PremiereController {

    @Autowired
    private PremiereService service;

    @Autowired
    private AnimeService animeService;

    @Autowired
    private AnimeMapper mapper;

    @Autowired
    private PremiereMapper premiereMapper;

    @GetMapping("/premiere/animes")
    public ResponseEntity<List<AnimeResponse>> findByChapterId(
            @RequestParam("animeId") long animeId) {
        Anime data = animeService.findById(animeId);
        if (data != null) {
            return ResponseEntity.ok(mapper.toAnimeListResponse(service.findByChapterId(animeId)));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/premiere/")
    public ResponseEntity<PremiereGenericResponse<List<PremiereResponse>>> create(
            @RequestBody PremiereRequest request) {
        List<PremiereResponse> response = premiereMapper.toPremiereListResponse(service.create(request));
        return ResponseEntity.ok(new PremiereGenericResponse<>(HttpStatus.OK.value(), "OK", response));
    }

    @DeleteMapping("/premiere/{animeId}/{chapterId}")
    public ResponseEntity<GenericResponse> delete(
            @PathVariable("animeId") long animeId,
            @PathVariable("chapterId") long chapterId) {
        service.delete(animeId, chapterId);
        return ResponseEntity.ok(new GenericResponse(HttpStatus.OK.value(), "OK"));
    }

}
