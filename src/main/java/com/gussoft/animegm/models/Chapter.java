package com.gussoft.animegm.models;

import static javax.persistence.FetchType.EAGER;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Chapter_Sequence")
    @SequenceGenerator(name = "Chapter_Sequence", sequenceName = "Chapter_Sequence", allocationSize = 10)
    private Long id;

    private String name;

    private int season;

    private String createAt;

    //@JsonIgnore
    @OneToMany(fetch = EAGER, mappedBy = "chapter")
    private List<ChapterDetail> details;

}
