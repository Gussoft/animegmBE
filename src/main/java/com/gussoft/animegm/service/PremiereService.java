package com.gussoft.animegm.service;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.models.Premiere;
import com.gussoft.animegm.transfer.request.PremiereRequest;
import java.util.List;

public interface PremiereService {

    List<Premiere> findAll();

    List<Anime> findByChapterId(Long animeId);

    List<Premiere> create(PremiereRequest request);

    void delete(Long animeId, Long chapterId);

    void deleteByAnimeId(Long animeId);

}
