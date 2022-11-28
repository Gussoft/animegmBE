package com.gussoft.animegm.service.impl;

import com.gussoft.animegm.models.Chapter;
import com.gussoft.animegm.models.ChapterDetail;
import com.gussoft.animegm.repository.ChapterDetailRepository;
import com.gussoft.animegm.repository.ChapterRepository;
import com.gussoft.animegm.service.ChapterDetailService;
import com.gussoft.animegm.transfer.request.ChapterDetailRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChapterDetailServiceImpl implements ChapterDetailService {

    @Autowired
    private ChapterDetailRepository repoDetail;

    @Autowired
    private ChapterRepository repo;

    @Override
    public Page<ChapterDetail> listAllPages(Pageable page) {
        return repoDetail.findAll(page);
    }

    @Override
    public List<ChapterDetail> findAll() {
        return repoDetail.findAll();
    }

    @Override
    public ChapterDetail findById(Long id) {
        ChapterDetail data = repoDetail.findById(id).orElse(null);
        if (data == null) {
            throw new RuntimeException("Id No Encontrado!");
        }
        return data;
    }

    @Override
    public ChapterDetail saved(ChapterDetailRequest obj, Long chapterId) {
        Chapter data =  repo.findById(chapterId).orElse(null);
        if (data == null) {
            throw new RuntimeException("Id No Encontrado!");
        }
        ChapterDetail detail = new ChapterDetail(obj.getLink(), obj.getDuration(), data);

        return repoDetail.save(detail);
    }

    @Override
    public ChapterDetail updated(ChapterDetailRequest obj, Long id) {
        repoDetail.update(id, obj.getLink(), obj.getDuration());
        ChapterDetail data = repoDetail.findById(id).orElse(null);
        if (data == null) {
            throw new RuntimeException("Id No Encontrado!");
        }
        return data;
    }

    @Override
    public void deleted(Long id) {
        repoDetail.deleteById(id);
    }
}
