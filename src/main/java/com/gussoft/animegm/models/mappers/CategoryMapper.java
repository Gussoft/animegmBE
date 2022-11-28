package com.gussoft.animegm.models.mappers;

import com.gussoft.animegm.models.Category;
import com.gussoft.animegm.transfer.response.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    @Autowired
    private ModelMapper mapper;

    public CategoryResponse toCategoryResponse(Category category) {
        return mapper.map(category, CategoryResponse.class);
    }

}
