package com.unipampa.BeerNote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.unipampa.BeerNote.data.BeerVO;
import com.unipampa.BeerNote.service.BeerService;
import com.unipampa.BeerNote.utils.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1/beer")
@CrossOrigin(origins = "*")
@Api(value = "API REST Cervejas")
public class BeerController {

        @Autowired
        BeerService beerService;

        @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YML })
        @ApiOperation(value = "Retorna uma lista de cerveja")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Retornou uma lista de cervejas"),
                        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
        })
        public List<BeerVO> listAllBeer() {
                return beerService.listAllBeer();
        }

        @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YML })
        @ApiOperation(value = "Retorna uma cerveja")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Pesquisou por id e retornou uma cerveja"),
                        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
        })
        public BeerVO findById(@PathVariable(name = "id") Integer id) {
                return beerService.listById(id);
        }

        @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
                                        MediaType.APPLICATION_XML,
                                        MediaType.APPLICATION_YML })
        @ApiOperation(value = "Cadastro de cerveja")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Cadastrou uma cerveja"),
                        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
        })
        public BeerVO saveBeer(@RequestBody BeerVO beer) {
                return beerService.saveBeer(beer);
        }

        @PutMapping(value = "", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
                                        MediaType.APPLICATION_XML,
                                        MediaType.APPLICATION_YML })
        @ApiOperation(value = "Atualiza as informações de uma cerveja")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Atualizou uma cerveja"),
                        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
        })
        public BeerVO updateBeer(@RequestBody BeerVO beer) {
                return beerService.updateBeer(beer);
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
