package com.unipampa.BeerNote.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class BeerDto {

    @NotBlank
    @Size(min = 4, max = 50)
    private String name;

    @NotBlank
    @Size (min = 10, max = 250)
    private String description;
}
