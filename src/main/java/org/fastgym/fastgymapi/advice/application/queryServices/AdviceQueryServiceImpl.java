package org.fastgym.fastgymapi.advice.application.queryServices;

import org.fastgym.fastgymapi.advice.domain.model.aggregates.Advice;
import org.fastgym.fastgymapi.advice.domain.model.queries.GetAdviceByIdQuery;
import org.fastgym.fastgymapi.advice.domain.model.queries.GetAdviceByNameQuery;
import org.fastgym.fastgymapi.advice.domain.services.AdviceQueryService;
import org.fastgym.fastgymapi.advice.infrastructure.jpa.repositories.AdviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdviceQueryServiceImpl implements AdviceQueryService {

    private final AdviceRepository adviceRepository;

    public AdviceQueryServiceImpl(AdviceRepository adviceRepository){
        this.adviceRepository = adviceRepository;
    }

    @Override
    public Optional<Advice> handle(GetAdviceByNameQuery query) {
        return adviceRepository.findAdviceByAdviceName(query.adviceName());
    }

    @Override
    public Optional<Advice> handle(GetAdviceByIdQuery query) {
        return adviceRepository.findById(query.id());
    }
}
