package com.gussoft.animegm.transfer.response;

import com.gussoft.animegm.models.Chapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDetailResponse {

    private Long id;

    private String link;

    private String duration;

    private Chapter chapter;

}
