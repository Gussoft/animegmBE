package com.gussoft.animegm.service;

import com.gussoft.animegm.models.Chapter;
import com.gussoft.animegm.transfer.request.ChapterRequest;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChapterService {

    Page<Chapter> listAllPages(Pageable page);

    List<Chapter> findAll();

    Chapter findById(Long id);

    Chapter saved(ChapterRequest obj);

    Chapter updated(ChapterRequest obj, Long id);

    void deleted(Long id);
}
