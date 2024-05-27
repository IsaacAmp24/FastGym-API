package org.fastgym.fastgymapi.profiles.interfaces.rest.transform;

import org.fastgym.fastgymapi.profiles.domain.model.commands.UpdateGymUserCommand;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.CreateGymUserResource;

public class UpdateGymUserCommandFromResourceAssembler {

    public static UpdateGymUserCommand toCommandFromResource(CreateGymUserResource resource, Long gymUserId){
        UpdateGymUserCommand command = new UpdateGymUserCommand(
                gymUserId,
                resource.name(),
                resource.email(),
                resource.planType()
        );
        return command;
    }
}
