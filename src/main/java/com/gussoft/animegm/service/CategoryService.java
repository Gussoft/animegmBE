package com.gussoft.animegm.service;

import com.gussoft.animegm.models.Category;
import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category saved(String name);

    Category updated(String name, Long id);

    void deleted(Long id);

}
