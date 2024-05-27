package org.fastgym.fastgymapi.profiles.interfaces.rest.transform;

import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateGymUserCommand;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.CreateGymUserResource;

public class CreateGymUserCommandFromResourceAssembler {
    public static CreateGymUserCommand toCommandFromResource(CreateGymUserResource resource) {
        return new CreateGymUserCommand(
                resource.name(),
                resource.email(),
                resource.planType());
    }
}
