package org.fastgym.fastgymapi.advice.domain.services;

import org.fastgym.fastgymapi.advice.domain.model.aggregates.Advice;
import org.fastgym.fastgymapi.advice.domain.model.queries.GetAdviceByIdQuery;
import org.fastgym.fastgymapi.advice.domain.model.queries.GetAdviceByNameQuery;

import java.util.Optional;

public interface AdviceQueryService {
    Optional<Advice> handle(GetAdviceByNameQuery query);
    Optional<Advice> handle(GetAdviceByIdQuery query);
}
