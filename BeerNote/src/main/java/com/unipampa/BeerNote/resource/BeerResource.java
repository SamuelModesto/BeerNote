package com.unipampa.BeerNote.resource;

import java.util.List;
import java.util.Optional;

import com.unipampa.BeerNote.dto.BeerDto;
import com.unipampa.BeerNote.model.Beer;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/beers")
@CrossOrigin(origins = "*")
@Api(value = "API REST Cervejas")
public class BeerResource {

        @Autowired
        private BeerService beerService;

        @GetMapping(value = "/all")
        @ApiOperation(value = "Retorna uma Lista de cervejas")
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
        public ResponseEntity<Beer> findById(@PathVariable(name = "id") Integer id) {
                return ResponseEntity.status(HttpStatus.OK).body(beerService.listById(id).get());
        }

        @PostMapping(value = "")
        @ApiOperation(value = "Cadastro de cerveja")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Cadastrou uma cerveja"),
                @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
        })
        public ResponseEntity<Beer> saveBeer(@RequestBody @Valid BeerDto dto) {
                var beer = new Beer();
                BeanUtils.copyProperties(dto, beer);
                return ResponseEntity.status(HttpStatus.CREATED).body(beerService.saveBeer(beer));
        }

        @PutMapping(value = "{id}")
        @ApiOperation(value = "Atualiza as informações de uma cerveja")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Atualizou uma cerveja"),
                @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
        })
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
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Deletou uma cerveja "),
                @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
        })
        public ResponseEntity<Object> deleteBeer(@PathVariable(value = "id") Integer id) {
                Optional<Beer> beer = beerService.listById(id);
                if(!beer.isPresent()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cerveja não encontrada!");
                }
                beerService.deleteBeer(beer.get());
                return ResponseEntity.status(HttpStatus.OK).body("Cerveja deletada com sucesso!");
        }
}
