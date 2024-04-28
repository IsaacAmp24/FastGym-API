package org.fastgym.fastgymapi.profiles.domain.services;

import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateGymUserCommand;

public interface GymUserCommandService {
    Long handle(CreateGymUserCommand command);
}
