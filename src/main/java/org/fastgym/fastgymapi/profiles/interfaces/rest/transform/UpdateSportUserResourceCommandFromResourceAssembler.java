package org.fastgym.fastgymapi.profiles.interfaces.rest.transform;

import org.fastgym.fastgymapi.profiles.domain.model.commands.UpdateSportUserCommand;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.CreateSportUserResource;

public class UpdateSportUserResourceCommandFromResourceAssembler {

    public static UpdateSportUserCommand toCommandFromResource(CreateSportUserResource resource, Long sportUserId){
        UpdateSportUserCommand command = new UpdateSportUserCommand(
                sportUserId,
                resource.name(),
                resource.email(),
                resource.sportName()
        );
        return command;
    }
}
