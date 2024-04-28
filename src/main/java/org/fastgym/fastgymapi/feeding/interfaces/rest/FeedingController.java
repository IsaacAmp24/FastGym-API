package org.fastgym.fastgymapi.feeding.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.fastgym.fastgymapi.feeding.domain.model.queries.GetFeedingByIdQuery;
import org.fastgym.fastgymapi.feeding.domain.model.queries.GetFeedingByNameQuery;
import org.fastgym.fastgymapi.feeding.domain.model.valueobjects.FeedingName;
import org.fastgym.fastgymapi.feeding.domain.services.FeedingCommandService;
import org.fastgym.fastgymapi.feeding.domain.services.FeedingQueryService;
import org.fastgym.fastgymapi.feeding.interfaces.rest.resources.CreateFeedingResource;
import org.fastgym.fastgymapi.feeding.interfaces.rest.resources.FeedingResource;
import org.fastgym.fastgymapi.feeding.interfaces.rest.transform.CreateFeedingCommandFromResourceAssembler;
import org.fastgym.fastgymapi.feeding.interfaces.rest.transform.FeedingResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/feedings")
@Tag(name = "Feedings", description = "Feedings Management Endpoints")
public class FeedingController {

    private final FeedingQueryService feedingQueryService;
    private final FeedingCommandService feedingCommandService;

    public FeedingController(FeedingQueryService feedingQueryService, FeedingCommandService feedingCommandService) {
        this.feedingQueryService = feedingQueryService;
        this.feedingCommandService = feedingCommandService;
    }

    // obtener alimentos por nombre
    @GetMapping("/{feedingName}")
    public ResponseEntity<FeedingResource> getFeedingByName(@PathVariable String feedingName) {
        var getFeedingByNameQuery = new GetFeedingByNameQuery(new FeedingName(feedingName));
        var feeding = feedingQueryService.handle(getFeedingByNameQuery);
        if (feeding.isEmpty()) return ResponseEntity.badRequest().build();
        var feedingResource = FeedingResourceFromEntityAssembler.toResourceFromEntity(feeding.get());
        return ResponseEntity.ok(feedingResource);
    }

    // obtener alimentos por id
    @GetMapping("/{feedingId}")
    public ResponseEntity<FeedingResource> getFeedingById(@PathVariable Long feedingId) {
        var getFeedingByIdQuery = new GetFeedingByIdQuery(feedingId);
        var feeding = feedingQueryService.handle(getFeedingByIdQuery);
        if (feeding.isEmpty()) return ResponseEntity.badRequest().build();
        var feedingResource = FeedingResourceFromEntityAssembler.toResourceFromEntity(feeding.get());
        return ResponseEntity.ok(feedingResource);
    }

    // crear alimento
    @PostMapping
    public ResponseEntity<FeedingResource> createFeeding(@RequestBody CreateFeedingResource resource) {
        var createFeedingCommand = CreateFeedingCommandFromResourceAssembler.toCommandFromResource(resource);
        var feedingId = feedingCommandService.handle(createFeedingCommand);
        if (feedingId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getFeedingByIdQuery = new GetFeedingByIdQuery(feedingId);
        var feeding = feedingQueryService.handle(getFeedingByIdQuery);
        if (feeding.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var feedingResource = FeedingResourceFromEntityAssembler.toResourceFromEntity(feeding.get());
        return ResponseEntity.ok(feedingResource);
    }


}
