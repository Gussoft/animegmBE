package com.gussoft.animegm.models.mappers;

import com.gussoft.animegm.models.Premiere;
import com.gussoft.animegm.transfer.response.PremiereResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PremiereMapper {

    @Autowired
    private ModelMapper mapper;

    public PremiereResponse toPremiereResponse(Premiere premiere) {
        return mapper.map(premiere, PremiereResponse.class);
    }

    public List<PremiereResponse> toPremiereListResponse(List<Premiere> premieres) {
        return premieres.stream()
                .map(premiere -> mapper.map(premiere, PremiereResponse.class))
                .collect(Collectors.toList());
    }
}
