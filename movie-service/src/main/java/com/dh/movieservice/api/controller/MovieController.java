package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.api.service.impl.MovieServiceImpl;
import com.dh.movieservice.api.service.queue.MovieSender;
import com.dh.movieservice.domain.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {
	private MovieServiceImpl movieService;

	private MovieSender movieSender;

	@Autowired
	public MovieController(MovieServiceImpl movieService, MovieSender movieSender) {
		this.movieService = movieService;
		this.movieSender = movieSender;
	}

	@GetMapping("/{genre}")
	public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		log.info("Listando las películas por género de: " + genre);
		return ResponseEntity.ok().body(movieService.getListByGenre(genre));
	}

	@PostMapping("/save")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		log.info("Se agregó la película: " + movie);
		var response = movieService.save(movie);
		movieSender.send(response);
		return ResponseEntity.ok().body(response);
	}


}
