package com.unipampa.BeerNote.controller;

import java.util.List;

import io.swagger.annotations.*;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unipampa.BeerNote.model.Beer;
import com.unipampa.BeerNote.service.BeerService;

@RestController
@RequestMapping(value = "/api/v1/beer")
@CrossOrigin(origins = "*")
@Api(value = "API REST Cervejas")
public class BeerController {

    @Autowired
    BeerService beerService;

    @GetMapping(value = "")
    @ApiOperation(value = "Retorna uma lista de cerveja")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornou uma lista de cervejas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public List<Beer> listAllBeer() {
        return beerService.listAllBeer();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna uma cerveja")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pesquisou por id e retornou uma cerveja"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public Beer findById(@PathVariable(name = "id") Integer id) {
        return beerService.listById(id);
    }

    @PostMapping(value = "")
    @ApiOperation(value = "Cadastro de cerveja")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastrou uma cerveja"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public Beer saveBeer(@RequestBody Beer beer) {
        return beerService.saveBeer(beer);
    }

    @PutMapping(value = "")
    @ApiOperation(value = "Atualiza as informações de uma cerveja")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizou uma cerveja"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public Beer updateBeer(@RequestBody Beer beer) {
        return beerService.saveBeer(beer);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta uma cerveja por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletou uma cerveja "),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity<?> deleteBeer(@PathVariable(value = "id") Integer id) {
        beerService.deleteBeer(id);
        return ResponseEntity.noContent().build();
    }
}
