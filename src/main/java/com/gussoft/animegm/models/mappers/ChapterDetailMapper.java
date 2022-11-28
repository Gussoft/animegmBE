package com.gussoft.animegm.models.mappers;

import com.gussoft.animegm.models.ChapterDetail;
import com.gussoft.animegm.transfer.response.ChapterDetailResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChapterDetailMapper {

    @Autowired
    private ModelMapper mapper;


    public ChapterDetailResponse toChapterDetailResponse(ChapterDetail detail) {
        return mapper.map(detail, ChapterDetailResponse.class);
    }

    public List<ChapterDetailResponse> toChapterDetailListResponse(List<ChapterDetail> chapters) {
        return chapters.stream()
                .map(chapter -> mapper.map(chapter, ChapterDetailResponse.class))
                .collect(Collectors.toList());
    }

}
