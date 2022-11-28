package com.gussoft.animegm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "animegm")
@NoArgsConstructor
@Getter
@Setter
public class Premiere {

    @EmbeddedId
    @JsonIgnore
    private PremiereId id;

    @ManyToOne
    @JoinColumn(name = "anime_id", insertable = false, updatable = false)
    private Anime anime;

    @ManyToOne
    @JoinColumn(name = "chapter_id", insertable = false, updatable = false)
    private Chapter chapter;

}
