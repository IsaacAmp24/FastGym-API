package org.fastgym.fastgymapi.profiles.domain.services;

import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateSportUserCommand;

public interface SportUserCommandService {
    Long handle(CreateSportUserCommand command);
}
