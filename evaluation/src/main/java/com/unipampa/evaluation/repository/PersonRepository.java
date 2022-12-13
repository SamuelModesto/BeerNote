package com.unipampa.evaluation.repository;

import com.unipampa.evaluation.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
