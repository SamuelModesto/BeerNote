package com.unipampa.evaluation.service;

import com.unipampa.evaluation.model.Beer;

import java.util.Optional;

public interface BeerService {

    Optional<Beer> findById(String id);
}
