package com.gussoft.animegm.transfer.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PremiereRequest {

    private Long animeId;

    private Long chapterId;

    private List<Integer> capitulos;

}
