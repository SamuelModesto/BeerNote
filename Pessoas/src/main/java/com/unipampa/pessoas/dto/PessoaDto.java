package com.unipampa.pessoas.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PessoaDto {

    @NotBlank
    @Size (min = 4, max = 50)
    private String name;

    @NotBlank
    @Size(min = 6, max = 20)
    private String user;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
}
