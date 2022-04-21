package com.dh.catalogservice.domain.model.document;

import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "catalog")
public class Catalog {

    @Id
    private String genre;
    private List<MovieWS> movies;
    private List<SerieWS> series;

    public Catalog(String genre, List<MovieWS> movieWSList, List<SerieWS> serieWSList) {
    }
}
