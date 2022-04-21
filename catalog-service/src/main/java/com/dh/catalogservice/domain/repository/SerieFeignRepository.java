package com.dh.catalogservice.domain.repository;


import com.dh.catalogservice.domain.model.dto.SerieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "serie-service")
public interface SerieFeignRepository {

    @GetMapping("/series/{genre}")
    List<SerieWS> getSeriesByGenre(@PathVariable String genre);

    @PostMapping("saveSerie")
    SerieWS saveSerie(@RequestBody SerieWS serie);


}
