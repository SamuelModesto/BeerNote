package com.unipampa.BeerNote.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unipampa.BeerNote.model.Beer;
import com.unipampa.BeerNote.service.BeerService;

@RestController
@RequestMapping(value = "/api/v1/beer")
public class BeerController {

    @Autowired
    BeerService beerService;

    @GetMapping(value = "")
    public List<Beer> listAllBeer() {
        return beerService.listAllBeer();
    }

    @GetMapping(value = "/{id}")
    public Beer findById(@PathVariable(name = "id") Integer id) {
        return beerService.listById(id);
    }

    @PostMapping(value = "")
    public Beer saveBeer(@RequestBody Beer beer) {
        return beerService.saveBeer(beer);
    }

    @PutMapping(value = "")
    public Beer updateBeer(@RequestBody Beer beer) {
        return beerService.saveBeer(beer);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBeer(@PathVariable(value = "id") Integer id) {
        beerService.deleteBeer(id);
        return ResponseEntity.noContent().build();
    }
}
