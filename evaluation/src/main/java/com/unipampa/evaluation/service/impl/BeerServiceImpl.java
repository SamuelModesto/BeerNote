package com.unipampa.evaluation.service.impl;

import com.unipampa.evaluation.model.Beer;
import com.unipampa.evaluation.repository.BeerRepository;
import com.unipampa.evaluation.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeerServiceImpl implements BeerService {

    @Autowired
    private BeerRepository repository;

    @Override
    public Optional<Beer> findById(String id) {
        return repository.findById(id);
    }
}
