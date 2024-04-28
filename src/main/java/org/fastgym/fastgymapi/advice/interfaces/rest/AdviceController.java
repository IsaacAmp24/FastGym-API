package org.fastgym.fastgymapi.advice.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.fastgym.fastgymapi.advice.domain.model.queries.GetAdviceByIdQuery;
import org.fastgym.fastgymapi.advice.domain.model.queries.GetAdviceByNameQuery;
import org.fastgym.fastgymapi.advice.domain.model.valueobjects.AdviceName;
import org.fastgym.fastgymapi.advice.domain.services.AdviceCommandService;
import org.fastgym.fastgymapi.advice.domain.services.AdviceQueryService;
import org.fastgym.fastgymapi.advice.interfaces.rest.resources.AdviceResource;
import org.fastgym.fastgymapi.advice.interfaces.rest.resources.CreateAdviceResource;
import org.fastgym.fastgymapi.advice.interfaces.rest.transform.AdviceResourceFromEntityAssembler;
import org.fastgym.fastgymapi.advice.interfaces.rest.transform.CreateAdviceCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1/advice", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Advice", description = "Advice Management Endpoints")
public class AdviceController {

    private final AdviceQueryService adviceQueryService;
    private final AdviceCommandService adviceCommandService;

    public AdviceController(AdviceQueryService adviceQueryService, AdviceCommandService adviceCommandService){
        this.adviceQueryService = adviceQueryService;
        this.adviceCommandService = adviceCommandService;
    }

    // obtengo los consejos por nombre
    @GetMapping("/{adviceName}")
    public ResponseEntity<AdviceResource> getAdviceByName(String adviceName){
        var getAdviceByNameQuery = new GetAdviceByNameQuery(new AdviceName(adviceName));
        var advice = adviceQueryService.handle(getAdviceByNameQuery);
        if (advice.isEmpty()) return ResponseEntity.badRequest().build();
        var adviceResource = AdviceResourceFromEntityAssembler.toResourceFromEntity(advice.get());
        return ResponseEntity.ok(adviceResource);
    }

    // add advice
    @PostMapping
    public ResponseEntity<AdviceResource> createAdvice(@RequestBody CreateAdviceResource resource) {
        var createAdviceCommand = CreateAdviceCommandFromResourceAssembler.toCommandFromResource(resource);
        var adviceId = adviceCommandService.handle(createAdviceCommand);
        if (adviceId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getAdviceByIdQuery = new GetAdviceByIdQuery(adviceId);
        var advice = adviceQueryService.handle(getAdviceByIdQuery);
        if (advice.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var adviceResource = AdviceResourceFromEntityAssembler.toResourceFromEntity(advice.get());
        return ResponseEntity.ok(adviceResource);
    }

}
