package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.document.Catalog;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;


public interface CatalogService {

    Catalog getCatalogFromGenre(String genre);
    Catalog saveMovieOnCatalog(MovieWS movieWS);
    Catalog saveSerieOnCatalog(SerieWS serieWS);

}
