package com.unipampa.evaluation.receiver;

import com.unipampa.evaluation.model.Beer;
import com.unipampa.evaluation.repository.BeerRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class BeerReceiver {

    private BeerRepository beerRepository;

    @Autowired
    public BeerReceiver(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @RabbitListener(queues = "${beer.rabbitmq.queueBeer}")
    public void receive(@Payload Beer beer){
        beerRepository.save(beer);
    }
}
