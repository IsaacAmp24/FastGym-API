package org.fastgym.fastgymapi.profiles.domain.services;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.SportUser;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByEmailQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByIdQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByNameQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserBySportNameQuery;

import java.util.Optional;

public interface SportUserQueryService {

    Optional <SportUser> handle(GetSportUserByIdQuery query);
    Optional <SportUser> handle(GetSportUserByNameQuery query);
    Optional <SportUser> handle(GetSportUserByEmailQuery query);
    Optional <SportUser> handle(GetSportUserBySportNameQuery query);

}
