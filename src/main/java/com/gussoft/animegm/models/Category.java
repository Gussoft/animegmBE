package com.gussoft.animegm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "animegm")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Category_Sequence")
    @SequenceGenerator(name = "Category_Sequence", sequenceName = "Category_Sequence", allocationSize = 10)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "category")
    @JsonIgnore
    private List<Anime> anime = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }
}
