package org.fastgym.fastgymapi.feeding.domain.services;

import org.fastgym.fastgymapi.feeding.domain.model.commands.CreateFeedingCommand;

public interface FeedingCommandService {

    Long handle(CreateFeedingCommand command);
}
