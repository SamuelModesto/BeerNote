package com.unipampa.Pessoas.sender;

import com.unipampa.Pessoas.model.Pessoa;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PessoaSender {

    @Value("${beer.rabbitmq.exchange}")
    String exchange;

    @Value("${beer.rabbitmq.routingkey}")
    String routingKey;

    public RabbitTemplate rabbitTemplate;

    @Autowired
    public PessoaSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Pessoa pessoa) {
        rabbitTemplate.convertAndSend(exchange, routingKey, pessoa);
    }
}
