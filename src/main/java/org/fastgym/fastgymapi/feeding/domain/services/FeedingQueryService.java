package org.fastgym.fastgymapi.feeding.domain.services;

import org.fastgym.fastgymapi.feeding.domain.model.aggregates.Feeding;
import org.fastgym.fastgymapi.feeding.domain.model.queries.GetFeedingByIdQuery;
import org.fastgym.fastgymapi.feeding.domain.model.queries.GetFeedingByNameQuery;
import org.fastgym.fastgymapi.feeding.domain.model.valueobjects.FeedingName;

import java.util.Optional;

public interface FeedingQueryService {

    Optional<Feeding> handle(GetFeedingByNameQuery query);

    Optional<Feeding> handle(GetFeedingByIdQuery query);
}
