package com.gussoft.animegm.models.mappers;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.transfer.response.AnimeResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class AnimeMapper {

    @Autowired
    private ModelMapper mapper;

    public AnimeResponse toAnimeResponse(Anime anime) {
        return mapper.map(anime, AnimeResponse.class);
    }

    public List<AnimeResponse> toAnimeListResponse(List<Anime> animes) {
        return animes.stream()
                .map(anime -> mapper.map(anime, AnimeResponse.class))
                .collect(Collectors.toList());
    }

}
