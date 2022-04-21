package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.SerieWS;

import java.util.List;

public interface SerieService {
    List<SerieWS> getSeriesByGenre(String genre);
    SerieWS saveMovie(SerieWS serie);
}
