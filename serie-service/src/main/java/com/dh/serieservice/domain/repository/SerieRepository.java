package com.dh.serieservice.domain.repository;

import com.dh.serieservice.domain.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


import java.util.List;

@EnableMongoRepositories
public interface SerieRepository extends MongoRepository<Serie, Integer> {

    List<Serie> findAllByGenre(String genre);
}
