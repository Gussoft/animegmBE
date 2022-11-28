package com.gussoft.animegm.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class PremiereId implements Serializable {

    private static final long serialVersionUID = 5740866683934399682L;

    @Column(name = "anime_id")
    private Long animeId;

    @Column(name = "chapter_id")
    private Long chapterId;

}
