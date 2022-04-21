package com.dh.serieservice.api.service.queue;

import com.dh.serieservice.api.service.impl.SerieServiceImpl;
import com.dh.serieservice.domain.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SerieSender {

    private final SerieServiceImpl client;

    private final RabbitTemplate rabbitTemplate;

    private final Queue serieQueue;

    public void send(Serie serie) {
        this.rabbitTemplate.convertAndSend(this.serieQueue.getName(), client.save(serie));
    }



}
