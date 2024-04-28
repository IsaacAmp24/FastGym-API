package org.fastgym.fastgymapi.profiles.domain.services;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.GymUser;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByEmailQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByIdQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByNameQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByPlanTypeQuery;

import java.util.Optional;

public interface GymUserQueryService {

    Optional<GymUser> handle(GetGymUserByIdQuery query);
    Optional<GymUser> handle(GetGymUserByNameQuery query);
    Optional<GymUser> handle(GetGymUserByEmailQuery query);
    Optional<GymUser> handle(GetGymUserByPlanTypeQuery query);

}
