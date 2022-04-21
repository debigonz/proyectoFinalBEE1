package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.document.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, Integer > {
    Optional<Catalog> findByGenre(String genre);
    void deleteByGenre(String genre);
}
