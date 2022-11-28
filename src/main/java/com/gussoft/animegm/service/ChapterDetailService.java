package com.gussoft.animegm.service;

import com.gussoft.animegm.models.ChapterDetail;
import com.gussoft.animegm.transfer.request.ChapterDetailRequest;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChapterDetailService {

    Page<ChapterDetail> listAllPages(Pageable page);

    List<ChapterDetail> findAll();

    ChapterDetail findById(Long id);

    ChapterDetail saved(ChapterDetailRequest obj, Long chapterId);

    ChapterDetail updated(ChapterDetailRequest obj, Long id);

    void deleted(Long id);

}
