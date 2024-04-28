package org.fastgym.fastgymapi.feeding.application.internal.queryServices;

import org.fastgym.fastgymapi.feeding.domain.model.aggregates.Feeding;
import org.fastgym.fastgymapi.feeding.domain.model.queries.GetFeedingByIdQuery;
import org.fastgym.fastgymapi.feeding.domain.model.queries.GetFeedingByNameQuery;
import org.fastgym.fastgymapi.feeding.domain.model.valueobjects.FeedingName;
import org.fastgym.fastgymapi.feeding.domain.services.FeedingQueryService;
import org.fastgym.fastgymapi.feeding.infrastructure.persistence.jpa.repositories.FeedingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedingQueryServiceImpl implements FeedingQueryService {

    private final FeedingRepository feedingRepository;

    public FeedingQueryServiceImpl(FeedingRepository feedingRepository) {
        this.feedingRepository = feedingRepository;
    }


    @Override
    public Optional<Feeding> handle(GetFeedingByNameQuery query) {
        return feedingRepository.findFeedingByFeedingName(query.feedingName());
    }

    @Override
    public Optional<Feeding> handle(GetFeedingByIdQuery query) {
        return feedingRepository.findById(query.id());
    }
}
