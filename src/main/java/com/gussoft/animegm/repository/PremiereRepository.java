package com.gussoft.animegm.repository;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.models.Premiere;
import com.gussoft.animegm.models.PremiereId;
import javax.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiereRepository extends JpaRepository<Premiere, PremiereId> {

    @Query("select distinct p.anime from Premiere p where p.id.animeId=:animeId order by p.anime.name asc ")
    List<Anime> findAnimeByChapterId(@Param("animeId") long animeId);

    @Query("select a from Premiere a inner join fetch a.chapter p inner join fetch a.anime f order by a.anime.id")
    List<Premiere> retrieveAll();

    @Query("select distinct p from Premiere p where p.id.chapterId=:chapterId")
    List<Premiere> findAnimeToChapterId(@Param("chapterId") long chapterId);

    @Modifying
    @Query("delete from Premiere a where a.anime.id =:id")
    @Transactional
    void deleteByAnimeId(@Param("id") long id);

}
