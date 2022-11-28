package com.gussoft.animegm.models;

import static javax.persistence.FetchType.EAGER;

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
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Anime_Sequence")
    @SequenceGenerator(name = "Anime_Sequence", sequenceName = "Anime_Sequence", allocationSize = 10)
    private Long id;

    private String name;

    private String synopsis;

    private String banner;

    //@JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "anime_category",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> category = new ArrayList<>();

    public void addCategory(Category category) {
        this.category.add(category);
        category.getAnime().add(this);
    }

    public void removeCategory(Long categoryId) {
        Category cat = this.category.stream().filter(c -> c.getId() == categoryId).findFirst().orElse(null);
        if (cat != null) {
            this.category.remove(cat);
            cat.getAnime().remove(this);
        }
    }
}
