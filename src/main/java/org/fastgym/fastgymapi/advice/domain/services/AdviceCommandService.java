package org.fastgym.fastgymapi.advice.domain.services;

import org.fastgym.fastgymapi.advice.domain.model.commands.CreateAdviceCommand;

public interface AdviceCommandService {
    Long handle(CreateAdviceCommand command);
}
