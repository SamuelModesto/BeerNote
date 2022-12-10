package com.unipampa.evaluation.controller;

import com.unipampa.evaluation.dto.EvaluationDto;
import com.unipampa.evaluation.model.Evaluation;
import com.unipampa.evaluation.service.EvaluationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService service;

    @PostMapping("/register")
    public ResponseEntity<Object> registerEvaluation(@RequestBody EvaluationDto dto) {
        var evaluation = new Evaluation();
        BeanUtils.copyProperties(dto, evaluation);
        service.createEvaluation(evaluation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Avaliação da cerveja foi salvo com sucesso!");
    }
}
