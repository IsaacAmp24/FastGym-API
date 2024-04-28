package org.fastgym.fastgymapi.feeding.interfaces.rest.transform;

import org.fastgym.fastgymapi.feeding.domain.model.commands.CreateFeedingCommand;
import org.fastgym.fastgymapi.feeding.interfaces.rest.resources.CreateFeedingResource;

public class CreateFeedingCommandFromResourceAssembler {
    public static CreateFeedingCommand toCommandFromResource(CreateFeedingResource resource) {
        return new CreateFeedingCommand(
                resource.name(),
                resource.description());
    }
}
