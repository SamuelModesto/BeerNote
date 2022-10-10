package com.unipampa.BeerNote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unipampa.BeerNote.model.Beer;
import com.unipampa.BeerNote.service.BeerService;

@RestController
@RequestMapping(value = "/api/v1/beer")
public class BeerController {

    @Autowired
    BeerService beerService;

    @GetMapping(value = "/all")
    public List<Beer> listAllBeer() {
        return beerService.listAllBeer();
    }
}
