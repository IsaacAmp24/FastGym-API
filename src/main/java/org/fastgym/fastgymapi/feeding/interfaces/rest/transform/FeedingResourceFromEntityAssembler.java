package org.fastgym.fastgymapi.feeding.interfaces.rest.transform;

import org.fastgym.fastgymapi.feeding.domain.model.aggregates.Feeding;
import org.fastgym.fastgymapi.feeding.interfaces.rest.resources.FeedingResource;

public class FeedingResourceFromEntityAssembler {
    public static FeedingResource toResourceFromEntity(Feeding entity) {
        return new FeedingResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription());
    }
}
