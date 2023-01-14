package com.unipampa.evaluation.dto;

import com.unipampa.evaluation.model.Beer;
import com.unipampa.evaluation.model.Person;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class EvaluationDto {

    @NotBlank
    @Size(min = 10, max = 250)
    private String description;

    @NotBlank
    private Person person;

    @NotBlank
    private Beer beer;
}
