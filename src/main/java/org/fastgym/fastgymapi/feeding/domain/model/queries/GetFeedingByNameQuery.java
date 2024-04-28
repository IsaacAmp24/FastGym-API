package org.fastgym.fastgymapi.feeding.domain.model.queries;

import org.fastgym.fastgymapi.feeding.domain.model.valueobjects.FeedingName;

public record GetFeedingByNameQuery(FeedingName feedingName) {
}
