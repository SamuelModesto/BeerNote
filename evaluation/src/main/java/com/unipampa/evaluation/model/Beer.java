package com.unipampa.evaluation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Beer {

    @Id
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @DBRef
    private Evaluation evaluation;
}
