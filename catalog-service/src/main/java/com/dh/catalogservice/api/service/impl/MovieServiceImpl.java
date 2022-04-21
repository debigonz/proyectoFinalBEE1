package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.MovieService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieFeignRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    private MovieFeignRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieFeignRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @CircuitBreaker(name = "movies", fallbackMethod = "findAllEmptyFallbackM")
    @Retry(name = "movies")
    @Override
    public List<MovieWS> getMoviesByGenre(String genre) {
        log.info("Calling movie service...");
        return movieRepository.getMoviesByGenre(genre);
    }

    @Override
    public MovieWS saveMovie(MovieWS movie){
        return movieRepository.saveMovie(movie);
    }

    private List<MovieWS> findAllEmptyFallbackM(CallNotPermittedException exception) {
        log.error("Circuit breaker was activated: {}" + exception.getMessage());
        return new ArrayList<>();
    }


}
