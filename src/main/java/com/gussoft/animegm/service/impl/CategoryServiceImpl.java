package com.gussoft.animegm.service.impl;

import com.gussoft.animegm.models.Category;
import com.gussoft.animegm.repository.CategoryRepository;
import com.gussoft.animegm.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repo;

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category findById(Long id) {
        Category data = repo.findById(id).orElse(null);
        if (data == null) {
            throw new RuntimeException("Id no encontrado!");
        }
        return data;
    }

    @Override
    public Category saved(String name) {
        Category data = new Category(name);
        return repo.save(data);
    }

    @Override
    public Category updated(String name, Long id) {

        Category data = repo.findById(id).orElse(null);
        if (data == null) {
            throw new RuntimeException("id no encontrado!");
        }
        data.setId(id);
        data.setName(name);
        return repo.save(data);
    }

    @Override
    public void deleted(Long id) {
        repo.deleteById(id);
    }
}
