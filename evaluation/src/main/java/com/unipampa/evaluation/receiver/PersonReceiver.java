package com.unipampa.evaluation.receiver;

import com.unipampa.evaluation.model.Person;
import com.unipampa.evaluation.repository.PersonRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PersonReceiver {

    private PersonRepository personRepository;

    @Autowired
    public PersonReceiver(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RabbitListener(queues = "${beer.rabbitmq.queuePessoa}")
    public void receive(@Payload Person person){
        personRepository.save(person);
    }
}
