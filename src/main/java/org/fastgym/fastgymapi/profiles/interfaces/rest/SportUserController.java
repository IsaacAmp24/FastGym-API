package org.fastgym.fastgymapi.profiles.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByIdQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByNameQuery;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.SportUserName;
import org.fastgym.fastgymapi.profiles.domain.services.SportUserCommandService;
import org.fastgym.fastgymapi.profiles.domain.services.SportUserQueryService;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.CreateSportUserResource;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.SportUserResource;
import org.fastgym.fastgymapi.profiles.interfaces.rest.transform.CreateSportUserCommandFromResourceAssembler;
import org.fastgym.fastgymapi.profiles.interfaces.rest.transform.SportUserResourceFromEntityAssembler;
import org.fastgym.fastgymapi.profiles.interfaces.rest.transform.UpdateSportUserResourceCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/sport-users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "UsersSport", description = "Sport Users Management Endpoints")
public class SportUserController {
    private final SportUserQueryService sportUserQueryService;
    private final SportUserCommandService sportUserCommandService;

    public SportUserController(SportUserQueryService sportUserQueryService, SportUserCommandService sportUserCommandService) {
        this.sportUserQueryService = sportUserQueryService;
        this.sportUserCommandService = sportUserCommandService;
    }

    @PostMapping
    public ResponseEntity<SportUserResource> createSportUser(@RequestBody CreateSportUserResource resource) {
        var createSportUserCommand = CreateSportUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var sportUserId = sportUserCommandService.handle(createSportUserCommand);
        if (sportUserId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getSportUserByIdQuery = new GetSportUserByIdQuery(sportUserId);
        var sportUser = sportUserQueryService.handle(getSportUserByIdQuery);
        if (sportUser.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var sportUserResource = SportUserResourceFromEntityAssembler.toResourceFromEntity(sportUser.get());
        return new ResponseEntity<>(sportUserResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SportUserResource> getSportUserById(@PathVariable Long id) {
        var getSportUserByIdQuery = new GetSportUserByIdQuery(id);
        var sportUser = sportUserQueryService.handle(getSportUserByIdQuery);
        if (sportUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var sportUserResource = SportUserResourceFromEntityAssembler.toResourceFromEntity(sportUser.get());
        return new ResponseEntity<>(sportUserResource, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SportUserResource> getSportUserByName(@PathVariable String name) {
        var getSportUserByNameQuery = new GetSportUserByNameQuery(new SportUserName(name));
        var sportUser = sportUserQueryService.handle(getSportUserByNameQuery);
        if (sportUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var sportUserResource = SportUserResourceFromEntityAssembler.toResourceFromEntity(sportUser.get());
        return new ResponseEntity<>(sportUserResource, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SportUserResource> updateSportUser(
            @PathVariable Long id,
            @RequestBody CreateSportUserResource resource) {

        // 1. obtener el sportUser existente
        var getSportUserByIdQuery = new GetSportUserByIdQuery(id);
        var existingSportUser = sportUserQueryService.handle(getSportUserByIdQuery);

        // 2. verificar si el sportUser existe
        if (existingSportUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // 3. comando para actualizar el sportUser
        var updateSportUserCommand = UpdateSportUserResourceCommandFromResourceAssembler.toCommandFromResource(resource, id);

        // 4. actualizar el sportUser existente
        var updatedSportUserId = sportUserCommandService.handle(updateSportUserCommand);

        // 5. recuperar el sportUser actualizado (opcional)
        var updateSportUser = existingSportUser.get();
        var sportUserResource = SportUserResourceFromEntityAssembler.toResourceFromEntity(updateSportUser);

        return new ResponseEntity<>(sportUserResource, HttpStatus.OK);
    }
}
