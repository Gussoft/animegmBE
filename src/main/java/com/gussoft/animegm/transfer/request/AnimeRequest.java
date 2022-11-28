package com.gussoft.animegm.transfer.request;

import com.gussoft.animegm.models.Category;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimeRequest {

    private String name;

    private String synopsis;

    private String banner;

    private List<Category> category;
}
