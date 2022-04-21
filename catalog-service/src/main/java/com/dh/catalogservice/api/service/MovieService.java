package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.MovieWS;

import java.util.List;

public interface MovieService {
    List<MovieWS> getMoviesByGenre(String genre);
    MovieWS saveMovie(MovieWS movie);
}
