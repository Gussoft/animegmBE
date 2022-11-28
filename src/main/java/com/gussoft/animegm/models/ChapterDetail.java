package com.gussoft.animegm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "animegm")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChapterDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ChapterDetail_Sequence")
    @SequenceGenerator(name = "ChapterDetail_Sequence", sequenceName = "ChapterDetail_Sequence", allocationSize = 10)
    private Long id;

    private String link;

    private String duration;

    @JoinColumn(name = "chapter_id")
    @ManyToOne
    @JsonIgnore
    private Chapter chapter;

    public ChapterDetail(String link, String duration, Chapter chapter) {
        this.link = link;
        this.duration = duration;
        this.chapter = chapter;
    }

}
