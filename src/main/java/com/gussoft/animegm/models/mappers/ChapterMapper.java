package com.gussoft.animegm.models.mappers;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.models.Chapter;
import com.gussoft.animegm.transfer.response.AnimeResponse;
import com.gussoft.animegm.transfer.response.ChapterResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChapterMapper {

    @Autowired
    private ModelMapper mapper;


    public ChapterResponse toChapterResponse(Chapter chapter) {
        return mapper.map(chapter, ChapterResponse.class);
    }

    public List<ChapterResponse> toChapterListResponse(List<Chapter> chapters) {
        return chapters.stream()
                .map(chapter -> mapper.map(chapter, ChapterResponse.class))
                .collect(Collectors.toList());
    }
}
