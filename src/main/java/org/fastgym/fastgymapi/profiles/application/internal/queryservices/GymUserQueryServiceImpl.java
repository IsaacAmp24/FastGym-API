package org.fastgym.fastgymapi.profiles.application.internal.queryservices;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.GymUser;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByEmailQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByIdQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByNameQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByPlanTypeQuery;
import org.fastgym.fastgymapi.profiles.domain.services.GymUserQueryService;
import org.fastgym.fastgymapi.profiles.infrastructure.persistence.jpa.repositories.GymUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GymUserQueryServiceImpl implements GymUserQueryService {

    private final GymUserRepository gymUserRepository;

    public GymUserQueryServiceImpl(GymUserRepository gymUserRepository) {
        this.gymUserRepository = gymUserRepository;
    }

    @Override
    public Optional<GymUser> handle(GetGymUserByIdQuery query) {
        return gymUserRepository.findById(query.id());
    }

    @Override
    public Optional<GymUser> handle(GetGymUserByNameQuery query) {
        return gymUserRepository.findUserGymByGymUserName(query.gymUserName());
    }

    @Override
    public Optional<GymUser> handle(GetGymUserByEmailQuery query) {
        return gymUserRepository.findUserGymByEmail(query.email());
    }

    @Override
    public Optional<GymUser> handle(GetGymUserByPlanTypeQuery query) {
        return gymUserRepository.findGymUsersByPlanType(query.gymUserPlanType());
    }

}
