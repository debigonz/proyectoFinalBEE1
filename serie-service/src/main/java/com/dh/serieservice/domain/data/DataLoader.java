package com.dh.serieservice.domain.data;

import com.dh.serieservice.domain.model.Chapter;
import com.dh.serieservice.domain.model.Season;
import com.dh.serieservice.domain.model.Serie;
import com.dh.serieservice.domain.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final SerieRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Chapter> chapterYou1 = new ArrayList<>();
        chapterYou1.add(new Chapter(1, "Pilot", 1, "https://www.netflix.com/ar/title/80211991"));
        List<Season> seasonYou1 = new ArrayList<>();
        seasonYou1.add(new Season(1, 1, chapterYou1));
        Serie serieYou = new Serie(1, "You", "Thriller", seasonYou1);

        List<Chapter> chapterLupin1 = new ArrayList<>();
        chapterLupin1.add(new Chapter(2, "Chapter1", 1, "https://www.netflix.com/ar/title/80994082"));
        List<Season> seasonLupin1 = new ArrayList<>();
        seasonLupin1.add(new Season(2, 1, chapterLupin1));
        Serie serieLupin = new Serie(2, "Lupin", "Action", seasonLupin1);

        List<Chapter> chapterClickbait1 = new ArrayList<>();
        chapterClickbait1.add(new Chapter(3, "The sister", 1,"https://www.netflix.com/ar/title/80991754"));
        List<Season> seasonClickbait1 = new ArrayList<>();
        seasonClickbait1.add(new Season(3, 1, chapterClickbait1));
        Serie serieClickbait = new Serie(3, "Clickbait", "Thriller", seasonClickbait1);

        repository.save(serieYou);
        repository.save(serieLupin);
        repository.save(serieClickbait);

    }
}
