package com.unipampa.Pessoas.sender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PessoaSender {

    @Value("${pessoa.rabbitmq.exchange}")
    String exchange;

    @Value("${pessoa.rabbitmq.routingkey}")
    String routingKey;
}
