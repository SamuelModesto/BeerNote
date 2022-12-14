package com.unipampa.evaluation.repository;

import com.unipampa.evaluation.model.Beer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeerRepository extends MongoRepository<Beer, String> {
}
