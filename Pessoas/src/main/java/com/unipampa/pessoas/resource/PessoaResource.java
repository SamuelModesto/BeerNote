package com.unipampa.pessoas.resource;


import com.unipampa.pessoas.dto.PessoaDto;
import com.unipampa.pessoas.model.Pessoa;
import com.unipampa.pessoas.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoas")
@CrossOrigin(origins = "*")
@Api(value = "API REST pessoas")
public class PessoaResource {

    @Autowired
    PessoaService service;

    @GetMapping(value = "/all")
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
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Integer id) {
        Optional<Pessoa> pessoaOptional = service.listById(id);
        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaOptional.get());
    }

    @PostMapping(value = "")
    @ApiOperation(value = "Cadastro de pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cadastrou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity<Object> savePessoa(@RequestBody PessoaDto pessoaDto) {
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePessoa(pessoa));
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza as informações de uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity<Object> updatePessoa(@PathVariable(value = "id") Integer id, @RequestBody PessoaDto pessoaDto) {
        Optional<Pessoa> pessoaOptional = service.listById(id);
        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        } else {
            var pessoa = pessoaOptional.get();
            BeanUtils.copyProperties(pessoaDto, pessoa);
            return ResponseEntity.status(HttpStatus.OK).body(service.savePessoa(pessoa));
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletou uma pessoa "),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity<Object> deletePessoa(@PathVariable(value = "id") Integer id) {
        Optional<Pessoa> pessoaOptional = service.listById(id);
        if(pessoaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
        }
        service.deletePessoaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada!");
    }

}
