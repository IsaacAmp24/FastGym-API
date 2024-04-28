package org.fastgym.fastgymapi.profiles.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByIdQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByNameQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByPlanTypeQuery;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserName;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserPlanType;
import org.fastgym.fastgymapi.profiles.domain.services.GymUserCommandService;
import org.fastgym.fastgymapi.profiles.domain.services.GymUserQueryService;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.CreateGymUserResource;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.GymUserResource;
import org.fastgym.fastgymapi.profiles.interfaces.rest.transform.CreateGymUserCommandFromResourceAssembler;
import org.fastgym.fastgymapi.profiles.interfaces.rest.transform.GymUserResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/gym-users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Gym Users", description = "Gym Users Management Endpoints")
public class GymUserController {
    private final GymUserQueryService gymUserQueryService;
    private final GymUserCommandService gymUserCommandService;

    public GymUserController(GymUserQueryService gymUserQueryService, GymUserCommandService gymUserCommandService) {
        this.gymUserQueryService = gymUserQueryService;
        this.gymUserCommandService = gymUserCommandService;
    }

    // crear usuario de gimnasio
    @PostMapping
    public ResponseEntity<GymUserResource> createGymUser(@RequestBody CreateGymUserResource resource) {
        var createGymUserCommand = CreateGymUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var gymUserId = gymUserCommandService.handle(createGymUserCommand);
        if (gymUserId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getGymUserByIdQuery = new GetGymUserByIdQuery(gymUserId);
        var gymUser = gymUserQueryService.handle(getGymUserByIdQuery);
        if (gymUser.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var gymUserResource = GymUserResourceFromEntityAssembler.toResourceFromEntity(gymUser.get());
        return new ResponseEntity<>(gymUserResource, HttpStatus.CREATED);
    }


    // obtener usuario de gimnasio por id
    @GetMapping("/{gymUserId}")
    public ResponseEntity<GymUserResource> getGymUserById(@PathVariable Long gymUserId) {
        var getGymUserByIdQuery = new GetGymUserByIdQuery(gymUserId);
        var gymUser = gymUserQueryService.handle(getGymUserByIdQuery);
        if (gymUser.isEmpty()) return ResponseEntity.badRequest().build();
        var gymUserResource = GymUserResourceFromEntityAssembler.toResourceFromEntity(gymUser.get());
        return ResponseEntity.ok(gymUserResource);
    }

    // obtener usuario de gimnasio por nombre
    @GetMapping("/name/{name}")
    public ResponseEntity<GymUserResource> getGymUserByName(@PathVariable String name) {
        var getGymUserByNameQuery = new GetGymUserByNameQuery(new GymUserName(name));
        var gymUser = gymUserQueryService.handle(getGymUserByNameQuery);
        if (gymUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var gymUserResource = GymUserResourceFromEntityAssembler.toResourceFromEntity(gymUser.get());
        return ResponseEntity.ok(gymUserResource);
    }

    // obtener usuario de gimnasio por tipo de plan
    @GetMapping("/plan-type/{gymUserPlanType}")
    public ResponseEntity<GymUserResource> getGymUserByPlanType(@PathVariable String gymUserPlanType) {
        var getGymUserByPlanTypeQuery = new GetGymUserByPlanTypeQuery(new GymUserPlanType(gymUserPlanType));
        var gymUser = gymUserQueryService.handle(getGymUserByPlanTypeQuery);
        if (gymUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var gymUserResource = GymUserResourceFromEntityAssembler.toResourceFromEntity(gymUser.get());
        return ResponseEntity.ok(gymUserResource);
    }



    // actualizar usuario de gimnasio por id
    @PutMapping("/{gymUserId}")
    public ResponseEntity<GymUserResource> updateGymUser(@PathVariable Long gymUserId, @RequestBody CreateGymUserResource resource) {
        var createGymUserCommand = CreateGymUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var resultUserId = gymUserCommandService.handle(createGymUserCommand);
        if (resultUserId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getGymUserByIdQuery = new GetGymUserByIdQuery(gymUserId);
        var gymUser = gymUserQueryService.handle(getGymUserByIdQuery);
        if (gymUser.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var gymUserResource = GymUserResourceFromEntityAssembler.toResourceFromEntity(gymUser.get());
        return new ResponseEntity<>(gymUserResource, HttpStatus.CREATED);
    }




}
