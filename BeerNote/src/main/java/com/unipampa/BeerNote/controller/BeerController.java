package com.unipampa.BeerNote.controller;

import java.util.List;
import java.util.Optional;

import com.unipampa.BeerNote.dto.BeerDto;
import com.unipampa.BeerNote.model.Beer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unipampa.BeerNote.service.BeerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.swing.text.html.Option;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/beer")
@CrossOrigin(origins = "*")
@Api(value = "API REST Cervejas")
public class BeerController {

        @Autowired
        private BeerService beerService;

        @GetMapping(value = "/all")
        public List<Beer> listAllBeer() {
                return beerService.listAllBeer();
        }

        @GetMapping(value = "/{id}")
        @ApiOperation(value = "Retorna uma cerveja")
        public ResponseEntity<Beer> findById(@PathVariable(name = "id") Integer id) {
                return ResponseEntity.status(HttpStatus.OK).body(beerService.listById(id).get());
        }

        @PostMapping(value = "")
        @ApiOperation(value = "Cadastro de cerveja")
        public ResponseEntity<Beer> saveBeer(@RequestBody @Valid BeerDto dto) {`
                var beer = new Beer();
                BeanUtils.copyProperties(dto, beer);
                return ResponseEntity.status(HttpStatus.CREATED).body(beerService.saveBeer(beer));
        }

        @PutMapping(value = "update/{id}")
        @ApiOperation(value = "Atualiza as informações de uma cerveja")
        public ResponseEntity<Object> updateBeer(@PathVariable Integer id, @RequestBody BeerDto dto) {

                Optional<Beer> beer = beerService.listById(id);
                if(!beer.isPresent()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cerveja não encontrada!");
                }
                var beerModel = beer.get();
                beerModel.setDescription(dto.getDescription());
                beerModel.setName(dto.getName());
                beerService.updateBeer(beerModel);
                return ResponseEntity.status(HttpStatus.OK).body("Cerveja atualizada com sucesso!");
        }

        @DeleteMapping(value = "/{id}")
        @ApiOperation(value = "Deleta uma cerveja por id")
        public ResponseEntity<Object> deleteBeer(@PathVariable(value = "id") Integer id) {
                Optional<Beer> beer = beerService.listById(id);
                if(!beer.isPresent()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cerveja não encontrada!");
                }
                beerService.deleteBeer(beer.get());
                return ResponseEntity.status(HttpStatus.OK).body("Cerveja deletada com sucesso!");
        }
}
