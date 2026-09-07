package com.pe.rabbit;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE = "empleado.exchange";
    public static final String ROUTING_KEY = "empleado.routingKey";
    // No declaramos la Queue aquí (usualmente la declara el consumidor)
    // pero sí el Exchange al cual enviaremos.

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }
}