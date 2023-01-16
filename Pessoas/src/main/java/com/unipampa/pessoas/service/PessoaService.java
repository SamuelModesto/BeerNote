package com.unipampa.pessoas.service;


import com.fasterxml.jackson.annotation.OptBoolean;
import com.unipampa.pessoas.model.Pessoa;
import com.unipampa.pessoas.repository.PessoaRepository;
import com.unipampa.pessoas.sender.PessoaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService  {

    private PessoaSender pessoaSender;

    private PessoaRepository repository;

    @Autowired
    public PessoaService(PessoaSender pessoaSender, PessoaRepository repository) {
        this.pessoaSender = pessoaSender;
        this.repository = repository;
    }

    public List<Pessoa> listAllPessoa(){
     return repository.findAll();
    }

    public Optional<Pessoa> listById(long id){
        return Optional.ofNullable(repository.findById(id));
    }

    public Pessoa savePessoa(Pessoa pessoa) {
        Pessoa returnPessoa = repository.save(pessoa);
        pessoaSender.sendMessage(pessoa);
        return returnPessoa;
    }

    public void deletePessoaById(long id){
        repository.deleteById(id);
    }
}
