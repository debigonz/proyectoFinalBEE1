package com.dh.serieservice.api.controller;

import com.dh.serieservice.api.service.SerieService;
import com.dh.serieservice.api.service.impl.SerieServiceImpl;
import com.dh.serieservice.api.service.queue.SerieSender;
import com.dh.serieservice.domain.model.Serie;
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
@RequestMapping("/series")
public class SerieController {

    private SerieServiceImpl serieService;

    private SerieSender serieSender;

    @Autowired
    public SerieController(SerieServiceImpl serieService, SerieSender serieSender) {
        this.serieService = serieService;
        this.serieSender = serieSender;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre){
        log.info("Listando series por el genero de: " + genre);
        return ResponseEntity.ok().body(serieService.getListByGenre(genre));
    }

    @PostMapping("/save")
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie){
        log.info("Se agregó la serie: " + serie + " en la lista.");
        var response = serieService.save(serie);
        serieSender.send(response);
        return ResponseEntity.ok().body(response);
    }


}
