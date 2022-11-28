package com.gussoft.animegm.transfer.response;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.models.Chapter;
import com.gussoft.animegm.models.PremiereId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PremiereResponse {

    private PremiereId id;

    private Anime anime;

    private Chapter chapter;

}
