package com.gussoft.animegm.service;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.transfer.request.AnimeRequest;
import java.util.List;
import com.gussoft.animegm.transfer.request.CategoryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnimeService {

    Page<Anime> listAllPages(Pageable page);

    List<Anime> findAll();

    Anime findById(Long id);

    Anime saved(AnimeRequest obj);

    Anime updated(AnimeRequest obj, Long id);

    void updateCategory(Long id, List<CategoryRequest> request);

    void deleted(Long id);

}
