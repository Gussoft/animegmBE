package com.gussoft.animegm.service.impl;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.models.Category;
import com.gussoft.animegm.repository.AnimeRepository;
import com.gussoft.animegm.repository.CategoryRepository;
import com.gussoft.animegm.service.AnimeService;
import com.gussoft.animegm.transfer.request.AnimeRequest;
import java.util.List;
import java.util.Optional;

import com.gussoft.animegm.transfer.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimeServiceImpl implements AnimeService {

    @Autowired
    private AnimeRepository repo;

    @Autowired
    private CategoryRepository repoCategory;

    @Override
    @Transactional(readOnly = true)
    public List<Anime> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Anime> listAllPages(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Anime findById(Long id) {
        Anime data = repo.findById(id).orElse(null);
        if (data == null) {
            throw new RuntimeException("Id no Encontrado!");
        }
        return data;
    }

    @Override
    public Anime saved(AnimeRequest obj) {
        Anime data = new Anime();
        data.setBanner(obj.getBanner());
        data.setName(obj.getName());
        data.setSynopsis(obj.getSynopsis());
        //data.setCategory(obj.getCategory());
        Anime anime = repo.save(data);

        return anime;
    }

    @Override
    public Anime updated(AnimeRequest obj, Long id) {
        Anime data = repo.findById(id).orElse(null);
        if (data == null) {
            throw new RuntimeException("Id no Encontrado!");
        }
        data.setName(obj.getName());
        data.setBanner(obj.getBanner());
        data.setSynopsis(obj.getSynopsis());

        return repo.save(data);
    }

    @Override
    public void updateCategory(Long id, List<CategoryRequest> request) {
        Anime data = repo.findById(id).orElse(null);
        if (data == null) {
            throw new RuntimeException("Id no Encontrado!");
        }
        Optional<Category> dataCategory = repoCategory.findById(id);
        Category category = new Category();
        for (CategoryRequest r : request) {
            if (dataCategory.isEmpty()) {
                category = repoCategory.save(new Category(r.getName()));
                data.addCategory(category);
                repo.save(data);
            } else {
                data.addCategory(dataCategory.get());
                repo.save(data);
            }
        }
    }

    @Override
    public void deleted(Long id) {
        repo.deleteById(id);
    }

}
