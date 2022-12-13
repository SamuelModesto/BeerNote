package com.unipampa.BeerNote.sender;

import com.unipampa.BeerNote.model.Beer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeerSender {

    @Value("${beer.rabbitmq.exchange}")
    String exchange;

    @Value("${beer.rabbitmq.routingkey}")
    String routingkey;

    public RabbitTemplate rabbitTemplate;

    @Autowired
    public BeerSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Beer beer) {
        rabbitTemplate.convertAndSend(exchange, routingkey, beer);
    }
}
