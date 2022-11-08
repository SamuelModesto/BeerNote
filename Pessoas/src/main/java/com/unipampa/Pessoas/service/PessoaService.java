package com.unipampa.Pessoas.service;


import com.unipampa.Pessoas.model.Pessoa;
import com.unipampa.Pessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService  {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> listAllPessoa(){
     return repository.findAll();
    }

    public Pessoa listById(long id){
        return repository.findById(id);
    }

    public Pessoa savePessoa(Pessoa pessoa){
       return repository.save(pessoa);
    }

    public void deletePessoaById(long id){
        repository.deleteById(id);
    }
}
