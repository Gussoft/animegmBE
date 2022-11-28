package com.gussoft.animegm.transfer.response;

import com.gussoft.animegm.models.ChapterDetail;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterResponse {

    private Long id;

    private String name;

    private int season;

    private String createAt;

    private List<ChapterDetail> details;

}
