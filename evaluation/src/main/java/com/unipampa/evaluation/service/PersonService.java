package com.unipampa.evaluation.service;

import com.unipampa.evaluation.model.Person;

import java.util.Optional;

public interface PersonService {

    Optional<Person> findById(String id);
}
