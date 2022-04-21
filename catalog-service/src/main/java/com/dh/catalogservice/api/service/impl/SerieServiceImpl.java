package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.SerieService;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import com.dh.catalogservice.domain.repository.SerieFeignRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SerieServiceImpl implements SerieService {

    private SerieFeignRepository serieRepository;

    @Autowired
    public SerieServiceImpl(SerieFeignRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @CircuitBreaker(name = "series", fallbackMethod = "findAllEmptyFallbackS")
    @Retry(name = "series")
    @Override
    public List<SerieWS> getSeriesByGenre(String genre) {
        log.info("Calling serie service...");
        return serieRepository.getSeriesByGenre(genre);
    }

    private List<SerieWS> findAllEmptyFallbackS(CallNotPermittedException exception) {
        log.error("Circuit breaker was activated: {}", exception.getMessage());
        return new ArrayList<>();
    }

    @Override
    public SerieWS saveMovie(SerieWS serie){
        return serieRepository.saveSerie(serie);
    }
}
