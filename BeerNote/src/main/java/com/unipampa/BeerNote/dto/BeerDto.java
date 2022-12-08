package com.unipampa.BeerNote.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BeerDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
