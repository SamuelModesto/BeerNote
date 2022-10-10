package com.unipampa.BeerNote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipampa.BeerNote.model.Beer;
import com.unipampa.BeerNote.repository.BeerRepository;

@Service
public class BeerService {

    @Autowired
    BeerRepository beerRepository;

    public List<Beer> listAllBeer() {
        return beerRepository.findAll();
    }

}
