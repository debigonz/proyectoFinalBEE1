package com.dh.catalogservice.core.config;

import org.apache.catalina.LifecycleState;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RabbitMQSenderConfig {

    @Value ("${queue.catalog.name}")
    private String catalogQueue;


    @Bean
    public Queue  queue() {
        return new Queue(this.catalogQueue, true);
    }
}
