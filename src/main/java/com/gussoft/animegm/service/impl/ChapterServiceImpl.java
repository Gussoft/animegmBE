package com.gussoft.animegm.service.impl;

import com.gussoft.animegm.models.Chapter;
import com.gussoft.animegm.models.ChapterDetail;
import com.gussoft.animegm.repository.ChapterDetailRepository;
import com.gussoft.animegm.repository.ChapterRepository;
import com.gussoft.animegm.service.ChapterService;
import com.gussoft.animegm.transfer.request.ChapterRequest;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository repo;

    @Autowired
    private ChapterDetailRepository repoDetail;

    @Override
    public Page<Chapter> listAllPages(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public List<Chapter> findAll() {
        return repo.findAll();
    }

    @Override
    public Chapter findById(Long id) {
        Chapter data = repo.findById(id).orElse(null);
        if (data == null) {
            throw new RuntimeException("id no Encontrado!");
        }
        return data;
    }

    @Override
    public Chapter saved(ChapterRequest obj) {
        Chapter data = new Chapter();
        data.setName(obj.getName());
        data.setCreateAt(obj.getCreateAt());
        data.setSeason(obj.getSeason());
        Chapter chapter = repo.save(data);
        List<ChapterDetail> details = obj.getDetails()
                .stream()
                .map(item -> new ChapterDetail(item.getLink(), item.getDuration(), chapter))
                .collect(Collectors.toList());
        repoDetail.saveAll(details);
        return repo.findById(chapter.getId()).orElse(null);
    }

    @Override
    public Chapter updated(ChapterRequest obj, Long id) {
        repo.update(id, obj.getName(), obj.getSeason(), obj.getCreateAt());
        Chapter data = repo.findById(id).orElse(null);
        if (data == null) {
            throw new RuntimeException("id no Encontrado!");
        }
        repoDetail.deleteByChapterId(id);
        List<ChapterDetail> details = obj.getDetails()
                .stream()
                .map(item -> new ChapterDetail(item.getLink(), item.getDuration(), data))
                .collect(Collectors.toList());
        repoDetail.saveAll(details);

        return repo.findById(data.getId()).orElse(null);
    }

    @Override
    public void deleted(Long id) {
        repoDetail.deleteByChapterId(id);
        repo.findById(id);
    }
}
