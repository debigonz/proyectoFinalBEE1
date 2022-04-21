package com.dh.catalogservice.api.queue;

import com.dh.catalogservice.api.service.impl.CatalogServiceImpl;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import com.dh.catalogservice.domain.repository.SerieFeignRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SerieListener {

    private final CatalogServiceImpl catalogService;

    @RabbitListener(queues = { "${queue.serie.name}" })
    public void receive(@Payload SerieWS serie) {
        log.info("Se guardo una serie en el catologo de "+ serie.getGenre());
        catalogService.saveSerieOnCatalog(serie);
    }
}
