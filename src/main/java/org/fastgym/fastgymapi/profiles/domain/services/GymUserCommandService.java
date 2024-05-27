package org.fastgym.fastgymapi.profiles.domain.services;

import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateGymUserCommand;
import org.fastgym.fastgymapi.profiles.domain.model.commands.UpdateGymUserCommand;

public interface GymUserCommandService {
    Long handle(CreateGymUserCommand command);
    Long handle(UpdateGymUserCommand command);
}
