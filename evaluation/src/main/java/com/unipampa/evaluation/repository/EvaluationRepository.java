package com.unipampa.evaluation.repository;

import com.unipampa.evaluation.model.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluationRepository extends MongoRepository<Evaluation, String> {
}
