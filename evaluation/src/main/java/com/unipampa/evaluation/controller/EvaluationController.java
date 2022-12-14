package com.unipampa.evaluation.controller;

import com.unipampa.evaluation.dto.EvaluationDto;
import com.unipampa.evaluation.model.Beer;
import com.unipampa.evaluation.model.Evaluation;
import com.unipampa.evaluation.model.Person;
import com.unipampa.evaluation.service.BeerService;
import com.unipampa.evaluation.service.EvaluationService;
import com.unipampa.evaluation.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService service;

    @Autowired
    private PersonService personService;

    @Autowired
    private BeerService beerService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerEvaluation(@RequestBody EvaluationDto dto) {
        var evaluation = new Evaluation();
        BeanUtils.copyProperties(dto, evaluation);

        Optional<Person> person = personService.findById(dto.getPerson().getId());
        evaluation.setPerson(person.get());
        Optional<Beer> beer = beerService.findById(dto.getBeer().getId());
        evaluation.setBeer(beer.get());

        service.createEvaluation(evaluation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Avaliação da cerveja foi salvo com sucesso!");
    }
}
