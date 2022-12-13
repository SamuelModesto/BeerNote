package com.unipampa.Pessoas.service;


import com.unipampa.Pessoas.model.Pessoa;
import com.unipampa.Pessoas.repository.PessoaRepository;
import com.unipampa.Pessoas.sender.PessoaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Pessoa listById(long id){
        return repository.findById(id);
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
