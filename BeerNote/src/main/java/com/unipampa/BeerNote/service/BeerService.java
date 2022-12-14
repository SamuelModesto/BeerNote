package com.unipampa.BeerNote.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.unipampa.BeerNote.sender.BeerSender;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.stereotype.Service;

import com.unipampa.BeerNote.model.Beer;
import com.unipampa.BeerNote.repository.BeerRepository;

@Service
public class BeerService {

    private BeerRepository beerRepository;

    private BeerSender beerSender;

    @Autowired
    public BeerService(BeerRepository beerRepository, BeerSender beerSender) {
        this.beerRepository = beerRepository;
        this.beerSender = beerSender;
    }

    private Logger logger = Logger.getLogger(BeerService.class.getName());

    public List<Beer> listAllBeer() {
        logger.info("Listando Cervejas");
        return beerRepository.findAll();
    }

    public Optional<Beer> listById(Integer id) {
        logger.info("Finding a Beer");
        return beerRepository.findById(id);
    }

    public Beer saveBeer(Beer beer) {
        logger.info("Creating a Beer");
        Beer returnBeer = beerRepository.save(beer);
        beerSender.sendMessage(beer);
        return returnBeer;
    }

    public Beer updateBeer(Beer beer) {
        logger.info("Updating Beer");
        beerRepository.save(beer);
        return beer;
    }

    public void deleteBeer(Beer beer) {
        logger.info("Deleting person");
        beerRepository.delete(beer);
    }

}
