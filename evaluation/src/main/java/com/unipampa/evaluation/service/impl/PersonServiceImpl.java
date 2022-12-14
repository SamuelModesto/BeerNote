package com.unipampa.evaluation.service.impl;

import com.unipampa.evaluation.model.Person;
import com.unipampa.evaluation.repository.PersonRepository;
import com.unipampa.evaluation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public Optional<Person> findById(String id) {
        return repository.findById(id);
    }
}
