package com.dh.catalogservice.api.queue;
import com.dh.catalogservice.api.service.impl.CatalogServiceImpl;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieListener {

    private final CatalogServiceImpl catalogService;

    @RabbitListener(queues = { "${queue.movie.name}" })
    public void receive(@Payload MovieWS movie) {
        catalogService.saveMovieOnCatalog(movie);
    }
}
