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
        // var beers = beerRepository.findAll();
        // beers.stream().forEach(b -> {
        // b.add(linkTo(methodOn(BeerController.class).findById(b.getId())).withSelfRel());
        // });
        // return beers;
    }

    public Beer listById(Integer id) {
        return beerRepository.findById(id);
    }

    public Beer saveBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    public void deleteBeer(Integer id) {
        Beer beer = beerRepository.findById(id);
        beerRepository.delete(beer);
    }

}
