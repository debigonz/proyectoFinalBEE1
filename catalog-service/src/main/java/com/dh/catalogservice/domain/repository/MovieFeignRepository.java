package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "movie-service")
public interface MovieFeignRepository {

    @GetMapping("/movies/{genre}")
    List<MovieWS> getMoviesByGenre(@PathVariable String genre);

    @PostMapping("saveMovie")
    MovieWS saveMovie(@RequestBody MovieWS movie);


}
