package com.dh.movieservice.api.service.queue;

import com.dh.movieservice.api.service.impl.MovieServiceImpl;
import com.dh.movieservice.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieSender {

    private final MovieServiceImpl client;

    private final RabbitTemplate rabbitTemplate;

    private final Queue movieQueue;

    public void send(Movie movie) {
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), client.save(movie));
    }

}
