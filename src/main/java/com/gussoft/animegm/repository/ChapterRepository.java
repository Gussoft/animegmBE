package com.gussoft.animegm.repository;

import com.gussoft.animegm.models.Chapter;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Transactional
    @Modifying
    @Query("update Chapter c set c.name=:name, c.season=:season, c.createAt=:createAt where c.id=:id")
    int update(@Param("id") Long id, @Param("name") String name, @Param("season") Integer season,
               @Param("createAt") String createAt);

}
