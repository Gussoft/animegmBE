package com.gussoft.animegm.service.impl;

import com.gussoft.animegm.models.Anime;
import com.gussoft.animegm.models.Chapter;
import com.gussoft.animegm.models.Premiere;
import com.gussoft.animegm.models.PremiereId;
import com.gussoft.animegm.repository.AnimeRepository;
import com.gussoft.animegm.repository.PremiereRepository;
import com.gussoft.animegm.service.ChapterService;
import com.gussoft.animegm.service.PremiereService;
import com.gussoft.animegm.transfer.request.PremiereRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiereServiceImpl implements PremiereService {

    @Autowired
    private PremiereRepository repo;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public List<Premiere> findAll() {
        return repo.retrieveAll();
    }

    @Override
    public List<Anime> findByChapterId(Long animeId) {
        return repo.findAnimeByChapterId(animeId);
    }

    @Override
    public List<Premiere> create(PremiereRequest request) {
        Optional<Anime> data = animeRepository.findById(request.getAnimeId());
        if (!data.isPresent()) {
            throw new RuntimeException("Id No encontrado!");
        }
        List<Premiere> premieres = request.getCapitulos().stream().map(ani -> {
            Chapter chapter = chapterService.findById(Long.valueOf(ani));
            if (chapter != null) {
                PremiereId id = new PremiereId(request.getAnimeId(), Long.valueOf(ani));
                if (!repo.existsById(id)) {
                    Premiere premiere = new Premiere();
                    premiere.setId(id);
                    premiere.setAnime(data.get());
                    premiere.setChapter(chapter);
                    return premiere;
                }
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        return repo.saveAll(premieres);
    }

    @Override
    public void delete(Long animeId, Long chapterId) {
        repo.deleteById(new PremiereId(animeId, chapterId));
    }

    @Override
    public void deleteByAnimeId(Long animeId) {
        repo.deleteByAnimeId(animeId);
    }
}

/*    Chapter data = chapterService.findById(request.getChapterId());
        if (data == null) {
                throw new RuntimeException("Id No encontrado!");
                }
                List<Premiere> premieres = request.getCIds().stream().map(ani -> {
        Optional<Anime> anime = animeRepository.findById(ani);
        if (anime.isPresent()) {
        PremiereId id = new PremiereId(ani, request.getChapterId());
        if (!repo.existsById(id)) {
        Premiere premiere = new Premiere();
        premiere.setId(id);
        premiere.setAnime(anime.get());
        premiere.setChapter(data);
        return premiere;
        }
        }
        return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        return repo.saveAll(premieres);*/
