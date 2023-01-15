package com.unipampa.evaluation.resource;

import com.unipampa.evaluation.dto.EvaluationDto;
import com.unipampa.evaluation.model.Beer;
import com.unipampa.evaluation.model.Evaluation;
import com.unipampa.evaluation.model.Person;
import com.unipampa.evaluation.service.BeerService;
import com.unipampa.evaluation.service.EvaluationService;
import com.unipampa.evaluation.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/evaluations")
@CrossOrigin(origins = "*")
@Api(value = "API REST evaluation")
public class EvaluationResource {

    @Autowired
    private EvaluationService service;

    @Autowired
    private PersonService personService;

    @Autowired
    private BeerService beerService;

    @PostMapping("/register")
    @ApiOperation(value = "Faz uma avaliação de cervejas")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cadastrou uma avaliação"),
            @ApiResponse(code = 401, message = "Você não está autorizado na aplicação"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
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
