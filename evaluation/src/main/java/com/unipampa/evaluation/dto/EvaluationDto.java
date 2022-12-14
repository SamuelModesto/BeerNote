package com.unipampa.evaluation.dto;

import com.unipampa.evaluation.model.Beer;
import com.unipampa.evaluation.model.Person;
import lombok.Data;

@Data
public class EvaluationDto {

    private String description;

    private Person person;

    private Beer beer;
}
