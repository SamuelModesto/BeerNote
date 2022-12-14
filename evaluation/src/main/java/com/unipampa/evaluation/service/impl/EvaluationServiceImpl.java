package com.unipampa.evaluation.service.impl;

import com.unipampa.evaluation.model.Evaluation;
import com.unipampa.evaluation.repository.EvaluationRepository;
import com.unipampa.evaluation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository repository;

    @Override
    public void createEvaluation(Evaluation evaluation) {
        repository.save(evaluation);
    }
}
