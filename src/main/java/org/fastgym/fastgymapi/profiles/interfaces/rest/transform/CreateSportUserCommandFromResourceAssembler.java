package org.fastgym.fastgymapi.profiles.interfaces.rest.transform;

import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateSportUserCommand;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.CreateSportUserResource;

public class CreateSportUserCommandFromResourceAssembler {
    public static CreateSportUserCommand toCommandFromResource(CreateSportUserResource resource) {
        return new CreateSportUserCommand(resource.name(), resource.email(), resource.sportName());
    }
}
