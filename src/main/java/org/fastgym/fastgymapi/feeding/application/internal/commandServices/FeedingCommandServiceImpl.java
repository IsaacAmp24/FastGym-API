package org.fastgym.fastgymapi.feeding.application.internal.commandServices;

import org.fastgym.fastgymapi.feeding.domain.model.aggregates.Feeding;
import org.fastgym.fastgymapi.feeding.domain.model.commands.CreateFeedingCommand;
import org.fastgym.fastgymapi.feeding.domain.services.FeedingCommandService;
import org.fastgym.fastgymapi.feeding.infrastructure.persistence.jpa.repositories.FeedingRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedingCommandServiceImpl implements FeedingCommandService {

    private final FeedingRepository feedingRepository;

    public FeedingCommandServiceImpl(FeedingRepository feedingRepository) {
        this.feedingRepository = feedingRepository;
    }

    @Override
    public Long handle(CreateFeedingCommand command) {
        var feeding = new Feeding(
                command.feedingName(),
                command.feedingDescription()
        );

        feedingRepository.save(feeding);
        return feeding.getId();
    }
}
