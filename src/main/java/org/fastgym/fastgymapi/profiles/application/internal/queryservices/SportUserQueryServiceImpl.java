package org.fastgym.fastgymapi.profiles.application.internal.queryservices;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.SportUser;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByEmailQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByIdQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByNameQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserBySportNameQuery;
import org.fastgym.fastgymapi.profiles.domain.services.SportUserQueryService;
import org.fastgym.fastgymapi.profiles.infrastructure.persistence.jpa.repositories.SportUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SportUserQueryServiceImpl implements SportUserQueryService {

    private final SportUserRepository sportUserRepository;

    public SportUserQueryServiceImpl(SportUserRepository sportUserRepository) {
        this.sportUserRepository = sportUserRepository;
    }

    @Override
    public Optional<SportUser> handle(GetSportUserByIdQuery query) {
        return sportUserRepository.findById(query.id());
    }

    @Override
    public Optional<SportUser> handle(GetSportUserByNameQuery query) {
        return sportUserRepository.findSportUsersByName(query.name());
    }

    @Override
    public Optional<SportUser> handle(GetSportUserByEmailQuery query) {
        return sportUserRepository.findSportUsersByEmail(query.email());
    }

    @Override
    public Optional<SportUser> handle(GetSportUserBySportNameQuery query) {
        return sportUserRepository.findSportUsersBySportName(query.sportName());
    }

}
