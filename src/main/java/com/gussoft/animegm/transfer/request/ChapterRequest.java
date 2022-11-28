package com.gussoft.animegm.transfer.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterRequest {

    private String name;

    private int season;

    private String createAt;

    private List<ChapterDetailRequest> details;

}
