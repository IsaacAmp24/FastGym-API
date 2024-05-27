package org.fastgym.fastgymapi.profiles.domain.services;

import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateSportUserCommand;
import org.fastgym.fastgymapi.profiles.domain.model.commands.UpdateSportUserCommand;

public interface SportUserCommandService {
    Long handle(CreateSportUserCommand command);
    Long handle(UpdateSportUserCommand command);
}
