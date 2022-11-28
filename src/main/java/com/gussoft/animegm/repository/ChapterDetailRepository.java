package com.gussoft.animegm.repository;

import com.gussoft.animegm.models.ChapterDetail;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterDetailRepository extends JpaRepository<ChapterDetail, Long> {

    @Modifying
    @Query("delete from ChapterDetail c where c.chapter.id=:id")
    @Transactional
    void deleteByChapterId(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update ChapterDetail d set d.link=:link, d.duration=:duration where d.id=:id")
    int update(
            @Param("id") Long id,
            @Param("link") String link,
            @Param("duration") String duration);
}
