package com.gussoft.animegm.repository;

import com.gussoft.animegm.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    List<Anime> findAnimeByCategoryId(Long categoryId);

}
