package com.unipampa.Pessoas.controller;


import com.unipampa.Pessoas.model.Pessoa;
import com.unipampa.Pessoas.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/Pessoa")
@CrossOrigin(origins = "*")
@Api(value = "API REST pessoas")
public class PessoaController {

    @Autowired
    PessoaService service;

    @GetMapping(value = "")
    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornou uma lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public List<Pessoa> listAllPessoas() {
        return service.listAllPessoa();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pesquisou por id e retornou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public Pessoa findById(@PathVariable(name = "id") Integer id) {
        return service.listById(id);
    }

    @PostMapping(value = "")
    @ApiOperation(value = "Cadastro de pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastrou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public Pessoa savePessoa(@RequestBody Pessoa pessoa) {
        return service.savePessoa(pessoa);
    }

    @PutMapping(value = "")
    @ApiOperation(value = "Atualiza as informações de uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public Pessoa updatePessoa(@RequestBody Pessoa pessoa) {
        return service.savePessoa(pessoa);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta uma pessoa por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletou uma pessoa "),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity<?> deletePessoa(@PathVariable(value = "id") Integer id) {
        service.deletePessoaById(id);
        return ResponseEntity.noContent().build();
    }

}
