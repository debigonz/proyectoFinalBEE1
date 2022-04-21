package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.document.Catalog;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import com.dh.catalogservice.domain.repository.CatalogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {

	private CatalogRepository catalogRepository;
	private MovieServiceImpl movieService;
	private SerieServiceImpl serieService;

	@Autowired
	public CatalogServiceImpl(MovieServiceImpl movieService, SerieServiceImpl serieService, CatalogRepository catalogRepository) {
		this.catalogRepository = catalogRepository;
		this.movieService = movieService;
		this.serieService = serieService;
	}

	public Catalog getCatalogFromGenre (String genre){
		List<MovieWS> movieList = movieService.getMoviesByGenre(genre);
		List<SerieWS> serieList = serieService.getSeriesByGenre(genre);

		Catalog catalog = new Catalog(genre,movieList, serieList);
		Catalog c = catalogRepository.findByGenre(genre).orElse(null);
		if(c != null){
			catalogRepository.deleteByGenre(genre);
		}

		catalogRepository.save(catalog);

		return catalog;
	}

	public Catalog saveMovieOnCatalog(MovieWS movie){
		Catalog catalog = catalogRepository.findByGenre(movie.getGenre()).get();
		catalog.getMovies().add(movie);
		return catalogRepository.save(catalog);
	}

	public Catalog saveSerieOnCatalog(SerieWS serie){
		Catalog catalog = catalogRepository.findByGenre(serie.getGenre()).get();
		catalog.getSeries().add(serie);
		return catalogRepository.save(catalog);
	}


}
